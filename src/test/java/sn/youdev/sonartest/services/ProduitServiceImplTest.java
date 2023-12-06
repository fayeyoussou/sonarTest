package sn.youdev.sonartest.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sn.youdev.sonartest.model.Produit;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProduitServiceImplTest {

    @Autowired
    private ProduitServiceImpl produitService;

    @Test
    void saveAndGetProduit() {
        Produit newProduit = new Produit();
        newProduit.setLibelle("Carte Ram 8Go");
        newProduit.setPrix(BigDecimal.valueOf(2000));
        newProduit.setCategorie("Informatique");
        Produit savedProduit = produitService.save(newProduit);

        assertNotNull(savedProduit.getId()); // Ensure the ID is generated

        Long savedProduitId = savedProduit.getId();
        Produit retrievedProduit = produitService.getProduit(savedProduitId);

        assertEquals(newProduit, retrievedProduit);
        produitService.deleteProduit(savedProduitId);
    }

    @Test
    void deleteProduit() {
        Produit newProduit = new Produit();
        Produit savedProduit = produitService.save(newProduit);
        newProduit.setLibelle("Delete Test");
        newProduit.setPrix(BigDecimal.valueOf(2000));
        newProduit.setCategorie("Delete");
        Long savedProduitId = savedProduit.getId();
        assertTrue(produitService.deleteProduit(savedProduitId));

        assertThrows(IllegalArgumentException.class, () -> produitService.getProduit(savedProduitId));
    }

    @Test
    void listerProduit() {
        // Assuming there are some produits in the database
        List<Produit> produits = produitService.listerProduit();

        assertNotNull(produits);
        assertFalse(produits.isEmpty());
    }
}