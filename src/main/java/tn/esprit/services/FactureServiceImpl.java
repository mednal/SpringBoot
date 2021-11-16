package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.FactureRepository;
import tn.esprit.model.Facture;

import java.util.List;
import java.util.Optional;

@Service
public class FactureServiceImpl implements FactureService{

    @Autowired
    private FactureRepository factureRepository;

    public FactureServiceImpl(FactureRepository factureRepository){
        this.factureRepository=factureRepository;
    }


    @Override
    public void ajouterFacture(Facture facture) {
        factureRepository.save(facture);
    }

    @Override
    public void supprimerFacture(long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public void supprimerToutLesFactures() {
        factureRepository.deleteAll();
    }

    @Override
    public void updatefacture(Facture facture, long id) {
        Facture f=factureRepository.findById(id).get();
        if (facture.getDateFacture()!=null){ f.setDateFacture(facture.getDateFacture()); }
        if(facture.getDetailFactures()!=null){f.setDetailFactures(facture.getDetailFactures());}
        if(facture.getMontantRemise()!=0){f.setMontantRemise(facture.getMontantRemise());}
        if(facture.getIdmontantFacture()!=0){f.setIdmontantFacture(facture.getIdmontantFacture());}
        factureRepository.save(f);
    }

    @Override
    public List<Facture> chercherFacture() {
        return factureRepository.findAll();
    }

    @Override
    public  Facture cherchefactureid(long id) {
      return  factureRepository.findById(id).get();
    }


}
