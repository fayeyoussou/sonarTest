package sn.youdev.sonartest.model;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ProduitTest {
    @Test
    void testCreate(){
        Produit produit = new Produit();
        produit.setId(1L);
        produit.setPrix(BigDecimal.valueOf(2000));
        produit.setCategorie("Informatique");
        produit.setLibelle("Carte SSD");
        assertEquals(1L, produit.getId());
        assertEquals("Carte SSD", produit.getLibelle());
        assertNotNull(produit.getCategorie());
    }
}