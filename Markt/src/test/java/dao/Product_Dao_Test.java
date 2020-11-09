package dao;

import domain.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Product_Dao_Test {

    @Mock
    private EntityManager emMock;
    @InjectMocks
    Product_Dao target;
    @Mock
    List<Product> productListMock = new ArrayList<>();
    @Mock
    TypedQuery typedQueryMock;
    @Mock
    private Product productMock;
    @Mock
    EntityTransaction transactionMock;


    @Test
    public void saveGebruikerTestFunctie() {
        when(emMock.getTransaction()).thenReturn(transactionMock);
        target.save(productMock);

        verify(transactionMock).begin();
        verify(emMock).persist(eq(productMock));
        verify(transactionMock).commit();

    }

    @Test
    public void findByEigenaarIdTest() {
        long id = 1;

        when(emMock.createQuery(anyString(), eq(Product.class))).thenReturn(typedQueryMock);
        when(typedQueryMock.getResultList()).thenReturn(productListMock);

        List<Product> producten = target.findByEigenaarId(id);

        verify(typedQueryMock).setParameter(anyString(), eq(String.valueOf(id)));
        assertEquals(productListMock, producten);
    }

    @Test
    public void getProductByIdTest() {
        long id = 1;
        when(emMock.find(any(), eq(id))).thenReturn(productMock);
        Product p = target.get(id);
        verify(emMock).find(eq(Product.class), eq(id));
        assertEquals(productMock, p);
    }

    @Test
    public void findAllProductenTest() {
        when(emMock.createQuery(anyString(), eq(Product.class))).thenReturn(typedQueryMock);
        when(typedQueryMock.getResultList()).thenReturn(productListMock);
        List<Product> pList = target.findAll();
        assertEquals(productListMock, pList);
    }


}