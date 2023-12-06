package sn.youdev.sonartest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Table(name = "produits")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "prix")
    private BigDecimal prix;
    private String categorie;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Objects.equals(id, produit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Produit(String libelle, BigDecimal prix, String categorie) {
        this.libelle = libelle;
        this.prix = prix;
        this.categorie = categorie;
    }
}
