package sn.youdev.sonartest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sn.youdev.sonartest.model.Produit;
import sn.youdev.sonartest.services.ProduitService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProduitControllerTest {

    private final ProduitService produitService = Mockito.mock(ProduitService.class);
    private final ProduitController produitController = new ProduitController(produitService);

    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(produitController).build();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void lister() throws Exception {
        // Given
        Produit produit1 = new Produit( "Libelle1", BigDecimal.valueOf(100), "Categorie1");
        Produit produit2 = new Produit( "Libelle2", BigDecimal.valueOf(200), "Categorie2");
        List<Produit> produits = Arrays.asList(produit1, produit2);

        Mockito.when(produitService.listerProduit()).thenReturn(produits);

        // When and Then
        mockMvc.perform(get("/produit"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].libelle").value("Libelle1"))
                .andExpect(jsonPath("$[1].libelle").value("Libelle2"));
    }

    @Test
    void findOne() throws Exception {
        // Given
        Long productId = 1L;
        Produit produit = new Produit(productId, "Libelle1", BigDecimal.valueOf(100), "Categorie1");

        Mockito.when(produitService.getProduit(productId)).thenReturn(produit);

        // When and Then
        mockMvc.perform(get("/produit/{id}", productId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.libelle").value("Libelle1"));
    }

    @Test
    void saveProduit() throws Exception {
        // Given
        Produit produitToSave = new Produit(null, "NewLibelle", BigDecimal.valueOf(300), "NewCategorie");
        Produit savedProduit = new Produit(1L, "NewLibelle", BigDecimal.valueOf(300), "NewCategorie");

        Mockito.when(produitService.save(any(Produit.class))).thenReturn(savedProduit);

        // When and Then
        mockMvc.perform(post("/produit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produitToSave)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.libelle").value("NewLibelle"));
    }

    @Test
    void deleteProduit() throws Exception {
        // Given
        Long productId = 1L;

        Mockito.when(produitService.deleteProduit(productId)).thenReturn(true);

        // When and Then
        mockMvc.perform(delete("/produit/{id}", productId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(true));
    }
}
