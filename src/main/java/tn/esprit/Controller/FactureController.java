package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Repositories.ClientRepository;
import tn.esprit.Repositories.ProduitRepository;
import tn.esprit.model.Client;
import tn.esprit.model.Facture;
import tn.esprit.model.Produit;
import tn.esprit.services.FactureServiceImpl;
import tn.esprit.services.ProduitServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/facture")
public class FactureController {
    @Autowired
    FactureServiceImpl factureServiceimpl;

    @Autowired
    ClientRepository clientRepository;

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

    @PostMapping("/updatefacture/{id}")
    public  void UpdateFacture(@RequestBody Facture facture,@PathVariable long id)
    {

        factureServiceimpl.updatefacture(facture,id);

    }

    @GetMapping("/getfacturebyclient/{idClient}")
    public List <Facture> getFactureByClient(Long idclient){
      Client p=clientRepository.findById(idclient).get();

        return clientRepository.retrieveFacturesByClient(idclient);

    }




}
