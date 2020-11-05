package FrontEnd;

import dao.Product_Dao;
import domain.BezorgOpties;
import domain.Product;
import domain.ProductStatus;
import org.App;

import java.time.LocalDate;

import static util.InvoerHelpers.*;

public class ProductAanbieden {

    Product_Dao product_dao = new Product_Dao(App.em);

    public void start() {

        while (true) {
            System.out.println("Product aanbieden");
            System.out.println("----------------------------------------------");
            productAanbieden();
            return;
        }
    }

    public void productAanbieden() {
        Product product = new Product();
        product.setEigenaarId(Hoofdpagina.ingelogdeGebruiker);
        product.setNaam(invoerveld("Naam"));
        product.setBeschrijving(invoerveld("Beschrijving"));
        product.setPrijs(invoerveldBigDecimal("Prijs"));
        product.setCategorie(invoerveld("Categorie"));
        product.setBezorgOpties(bezorgOptiesAanmaken(Hoofdpagina.ingelogdeGebruiker.getBezorgOpties()));
        product.setDatumPlaatsing(LocalDate.now());
        product.setStatus(ProductStatus.TEKOOP);

        product_dao.save(product);
        System.out.println(product_dao.get(1l));
        System.out.println("Product succesvol aangemaakt");
    }

    private BezorgOpties bezorgOptiesAanmaken(BezorgOpties bo) {
        BezorgOpties pbo = new BezorgOpties();
        if (bo.isAfhalen()) {
            pbo.setAfhalen(invoerveldYN("Afhalen bij de verkoper?"));
        }
        if (bo.isMagazijn()) {
            pbo.setMagazijn(invoerveldYN("Afhalen op het magazijn?"));
        }
        if (bo.isVersturen()) {
            pbo.setVersturen(invoerveldYN("Versturen zonder rembours?"));
        }
        if (bo.isRembours()) {
            pbo.setRembours(invoerveldYN("Versturen met rembours?"));
        }
        return pbo;
    }
}
