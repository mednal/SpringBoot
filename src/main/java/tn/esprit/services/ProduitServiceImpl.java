package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.FactureRepository;
import tn.esprit.Repositories.ProduitRepository;
import tn.esprit.model.Facture;
import tn.esprit.model.Produit;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepository;
@Autowired
    FactureRepository factureRepository;
    @Override
    public void addProduit(Produit produit) {
        produitRepository.save(produit);


    }

    @Override
    public Produit getProduitById(long id) {
        return  produitRepository.findById(id).get();
    }

    @Override
    public void updateProduit(Produit produit, long id) {
        Produit p=produitRepository.findById(id).get();
        if (produit.getStock()!=null){ p.setStock(produit.getStock()); }
        if(produit.getDetailProduit()!=null){p.setDetailProduit(produit.getDetailProduit());}
        if(produit.getLibelle()!=null){p.setLibelle(produit.getLibelle());}
       // if(produit.getIdmontantFacture()!=0){p.setIdmontantFacture(facture.getIdmontantFacture());}
        produitRepository.save(p);
    }




}
