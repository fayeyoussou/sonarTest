package sn.youdev.sonartest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.youdev.sonartest.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
