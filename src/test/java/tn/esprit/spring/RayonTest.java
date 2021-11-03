package tn.esprit.spring;


import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.model.Rayon;
import tn.esprit.services.RayonServiceImp;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
public class RayonTest  {


    @Autowired
    RayonServiceImp rayonServiceImp;

    @Test

    public void Test(){
        Rayon r=new Rayon();
        r.setCode("254879632");
        r.setLibelle("Sport");
        rayonServiceImp.addRayon(r);
    }

    




}
