package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Rayon;
import tn.esprit.services.RayonServiceImp;

import java.util.List;



@RestController
@RequestMapping("/api/stock")
public class RayonController
{
    @Autowired
    private RayonServiceImp rayonServiceImp;

    public RayonController( RayonServiceImp rayonServiceImp){
        this.rayonServiceImp=rayonServiceImp;
    }


    @GetMapping("/getAllrayon")
public List<Rayon> getAllRayon(){
return rayonServiceImp.getAllRayon();
}

    @PostMapping("/addrayon")
public String  getAllRayoaddrayon(@RequestBody  Rayon rayon){
 rayonServiceImp.addRayon(rayon);
 return "Rayon added !";
}


@GetMapping("/deletrayon/{id}")
public String deletRayon(@PathVariable(value = "id") long id){
        rayonServiceImp.delet(id);
return "rayon deleted ! " ;
}

public String update(@PathVariable (value ="id") long id  ){


        return  "rayon updated ! ";
}

}
