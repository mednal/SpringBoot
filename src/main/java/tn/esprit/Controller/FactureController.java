package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.model.Facture;
import tn.esprit.services.FactureServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/facture")
public class FactureController {
    @Autowired
    FactureServiceImpl factureServiceimpl;

    public FactureController(FactureServiceImpl factureServiceimpl){this.factureServiceimpl=factureServiceimpl;}


    @PostMapping("/addfacture")
    public String AddFacture(Facture facture){

        factureServiceimpl.ajouterFacture(facture);
        return "Facture ajouter";

    }

@GetMapping("/findfacture")
    public List<Facture> chercherfacture(){
    return   factureServiceimpl.chercherFacture();

    }

    @GetMapping("/findfactureid")
    public Facture ChercherFactureById(long id){

        return factureServiceimpl.cherchefactureid(id);
    }

    @PostMapping("/updatefacture")
    public  String UpdateFacture(Facture facture,long id)
    {
        factureServiceimpl.updatefacture(facture,id);
    return "Facture updated";
    }
}
