package sn.youdev.sonartest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Table(name = "produits")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "prix")
    private BigDecimal prix;
    private String categorie;
}
