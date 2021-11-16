package tn.esprit.services;


import tn.esprit.model.Facture;
import tn.esprit.model.Produit;

import java.util.List;

public interface ProduitService {
    public void addProduit(Produit produit);
    public Produit getProduitById(long id);
    public void updateProduit(Produit produit, long id);

}
