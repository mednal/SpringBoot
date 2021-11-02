package tn.esprit.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Facture;
import tn.esprit.services.FactureServiceImpl;

@RestController
@RequestMapping("/api/facture")
public class FactureController {

    @Autowired
    FactureServiceImpl factureService;

    @PostMapping("addfacture")
    public String addfacture(@RequestBody Facture facture)
    {
        factureService.ajouterFacture(facture);
        return  "FACTURE AFJOUTER";
    }


    @GetMapping("/deletfacture/{id}")
    public String supprimerFacture(@PathVariable (value = "id")long id)
    {
        factureService.supprimerFacture(id);
        return "facture deleted";
    }

    @GetMapping("/updatefacture/{id}")
    public String deletfacture(@RequestBody Facture facture,@PathVariable long id)
    {
        factureService.updatefacture(facture,id);
        return "facture has been updated !";
    }

    @GetMapping("getfactureid{id}")
    public String getFctureById(long id)
    {

        factureService.cherchefactureid(id);
    return "Facture !";
    }
}
