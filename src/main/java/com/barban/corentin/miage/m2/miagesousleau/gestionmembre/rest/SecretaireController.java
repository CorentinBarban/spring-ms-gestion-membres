package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Secretaire;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionMembreMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membres/secretaires")
public class SecretaireController {

    Logger logger = LoggerFactory.getLogger(SecretaireController.class);

    @Autowired
    GestionMembreMetier gestionMembreMetier;

    @PostMapping(path = "")
    public Secretaire postSecretaire(@RequestBody Secretaire secretaire) {
        logger.info("Creation d'un nouveau secretaire : " + secretaire);
        return this.gestionMembreMetier.creerSecretaire(secretaire);
    }
}
