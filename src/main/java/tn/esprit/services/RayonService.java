package tn.esprit.services;


import tn.esprit.model.Rayon;

import java.util.List;

public interface RayonService {
    public void addRayon(Rayon rayon);
    public String delet( long id);
    public String updaterayon( long id);
    public Rayon getRayonById(long id);
    public List<Rayon> getAllRayon();
}
