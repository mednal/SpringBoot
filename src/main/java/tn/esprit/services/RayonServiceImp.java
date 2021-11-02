package tn.esprit.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.RayonRepository;
import tn.esprit.model.Rayon;

import java.util.List;

@Service
public class RayonServiceImp implements RayonService{
    @Autowired
    RayonRepository rayonRepository;

    @Override
    public void addRayon(Rayon rayon) {
        if(!rayonRepository.findById(rayon.getIdRayon()).isPresent()){
            rayonRepository.save(rayon);
        }else{
            System.out.println("Rayon existe déja");
        }
    }

    @Override
    public String delet(long id) {
        rayonRepository.deleteById(id);

        return "rayon deleted";
    }

    @Override
    public String updaterayon(long id) {
        return null;
    }


    @Override
    public Rayon getRayonById(long id) {
        return rayonRepository.findById(id).get();
    }

    @Override
    public List<Rayon> getAllRayon() {
      return rayonRepository.findAll();
    }
}
