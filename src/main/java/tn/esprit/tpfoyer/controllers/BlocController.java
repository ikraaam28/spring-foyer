package tn.esprit.tpfoyer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.services.IBlocService;

@RestController
public class BlocController {
    @Autowired
    IBlocService iBlocService;
}
