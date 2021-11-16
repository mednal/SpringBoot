package tn.esprit.services;



import tn.esprit.model.Facture;

import java.util.List;
import java.util.Optional;

public interface FactureService {
    void ajouterFacture(Facture factures);
    void supprimerFacture(long id);
    void supprimerToutLesFactures();
    void updatefacture(Facture facture , long id);
    List<Facture> chercherFacture();
  Facture cherchefactureid(long id);


}
