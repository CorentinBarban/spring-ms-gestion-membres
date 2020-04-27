package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Paiement;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.MembreNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionPaiementMetier;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionMembreMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/membres/paiements")
public class PaiementController {

    Logger logger = LoggerFactory.getLogger(MembreController.class);

    @Autowired
    GestionMembreMetier gestionMembreMetier;

    @Autowired
    GestionPaiementMetier gestionPaiementMetier;


    @PostMapping(path = "")
    public Paiement payerCotisation(@RequestBody Paiement paiement) {
        logger.info("Réaliser le paiement de la cotisation");
        try {
            return this.gestionPaiementMetier.payerCotisation(paiement);
        } catch (MembreNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }


}
