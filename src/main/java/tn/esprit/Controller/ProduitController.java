package tn.esprit.Controller;

import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.model.Fournisseur;
import tn.esprit.model.Produit;
import tn.esprit.model.Stock;
import tn.esprit.services.*;

import java.util.Optional;
import java.util.Set;


@RequestMapping("/api/produit")
@RestController
public class ProduitController {

@Autowired
ProduitServiceImpl produitService;

@Autowired
    StockServiceImpl stockService;

@Autowired
    FournisseurServiceImpl fournisseurService;
@PostMapping("/addproduit")
public String ajouterproduit(Produit produit)
{
    produitService.addProduit(produit);
    return "prduct added";
}


@PostMapping("/assignproduittostock")
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p=produitService.getProduitById(idProduit);
        Stock s=stockService.getStockById(idStock);

        if(p.getStock()==s){
            System.out.println("Stock already assigned");
        }

        else{
            p.setStock(s);
            produitService.updateProduit(p,idProduit);
        }

    }
@PostMapping("assignfournisseuertoproduit")
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {

    Produit p=produitService.getProduitById(produitId);
    Fournisseur f= fournisseurService.getFournisseurById(fournisseurId);

    if(p.getFournisseurProduit()==f){
        System.out.println("Product has already an provider");
    }

    else {
p.setFournisseurProduit((Set<Fournisseur>) f);
produitService.updateProduit(p,produitId);

    }
}



}
