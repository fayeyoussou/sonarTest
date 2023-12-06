package sn.youdev.sonartest.services;

import sn.youdev.sonartest.model.Produit;

import java.util.List;

public interface ProduitService {
    Produit getProduit(Long id);
    Boolean deleteProduit(Long id);
    Produit save(Produit produit);
    List<Produit> listerProduit();
}
