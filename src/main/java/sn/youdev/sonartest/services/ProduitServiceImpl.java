package sn.youdev.sonartest.services;

import org.springframework.stereotype.Service;
import sn.youdev.sonartest.model.Produit;
import sn.youdev.sonartest.repository.ProduitRepository;

import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository repo;

    public ProduitServiceImpl(ProduitRepository repo) {
        this.repo = repo;
    }

    public Produit getProduit(Long id){
        return repo.findById(id).orElseThrow(IllegalArgumentException::new);
    }
    @Override
    public Boolean deleteProduit(Long id) {
        Produit produit = getProduit(id);
        repo.delete(produit);
        return true;
    }

    @Override
    public Produit save(Produit produit) {
        return repo.save(produit);
    }

    @Override
    public List<Produit> listerProduit() {
        return repo.findAll();
    }
}
