package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.FactureRepository;
import tn.esprit.model.Facture;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        if(facture.getmontantFacture()!=0){f.setmontantFacture(facture.getmontantFacture());}
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


    @Scheduled(cron = "0 0 0 1 1/1 * ")// *=la3wem lkol 1/1 awel nhar mn kol chhar 1
    @Override
    public void revenuTotal(){
        int period=1; // awel chhar
        List<Facture> factures= (List<Facture>)factureRepository.findAll();// w9eft lena 9bal ftour.

        float total=0; //total des factures
        for (Facture facture : factures){
            if (facture.getDateFacture().getMonth()==period){
                total=total+facture.getmontantFacture();
            }
        }
        System.out.println(total);
    }
}
