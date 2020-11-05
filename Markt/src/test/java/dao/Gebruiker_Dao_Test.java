package dao;

import domain.Gebruiker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Gebruiker_Dao_Test {

    @Mock
    private EntityManager emMock;
    @InjectMocks
    Gebruiker_Dao target;
    @Mock
    private EntityTransaction transactionMock;
    @Mock
    private Gebruiker gebruikerMock;
    @Mock
    TypedQuery typedQueryMock;

    @Test
    public void saveGebruikerTestFunctie() {
        when(emMock.getTransaction()).thenReturn(transactionMock);
        target.save(gebruikerMock);

        verify(transactionMock).begin();
        verify(emMock).persist(eq(gebruikerMock));
        verify(transactionMock).commit();

    }

    @Test
    public void saveGebruikerTestNull() {
        assertThrows(NullPointerException.class, () -> target.save(null));
    }

    @Test
    public void getByEmailTest() {
        //given
        String email = "test@test.nl";
        when(emMock.createQuery(any(), eq(Gebruiker.class))).thenReturn(typedQueryMock);
        when(typedQueryMock.getSingleResult()).thenReturn(gebruikerMock);


        Gebruiker gebruiker = target.getByEmail(email);

        verify(typedQueryMock).setParameter(anyString(),eq(email));
        assertEquals(gebruikerMock, gebruiker);

    }
}