package sn.youdev.sonartest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.youdev.sonartest.model.Produit;
import sn.youdev.sonartest.services.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Produit>> lister(){
        return ResponseEntity.ok(service.listerProduit());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produit> findOne(@PathVariable("id") final Long id){
        return ResponseEntity.ok(service.getProduit(id));
    }
    @PostMapping
    public ResponseEntity<Produit> saveProduit(@RequestBody final Produit produit){
        return ResponseEntity.ok(service.save(produit));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProduit(@PathVariable("id") final Long id){
        return ResponseEntity.ok(service.deleteProduit(id));
    }
}
