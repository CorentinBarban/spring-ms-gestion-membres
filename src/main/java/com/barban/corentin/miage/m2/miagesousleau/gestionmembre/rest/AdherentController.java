package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Adherent;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.MembreNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionMembreMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/membres/adherents")
public class AdherentController {

    Logger logger = LoggerFactory.getLogger(AdherentController.class);

    @Autowired
    GestionMembreMetier gestionMembreMetier;

    @PostMapping(path = "")
    public Adherent postAdherent(@RequestBody Adherent adherent) {
        logger.info("Creation d'un nouvel adhérent : " + adherent);
        return this.gestionMembreMetier.creerAdherent(adherent);
    }

    @GetMapping(path = "")
    public Iterable<Adherent> getListAdherent() {
        logger.info("Lister l'ensemble des adherents");
        return this.gestionMembreMetier.listerAdherent();
    }

    @GetMapping(path = "/{id}")
    public Adherent getAdherent(@PathVariable("id") Long idAdherent) {
        logger.info("Lister les informations d'un adherent");
        try {
            return (Adherent) this.gestionMembreMetier.getMembre(idAdherent);
        } catch (MembreNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Adhérent Not Found", e);
        }
    }

    @PutMapping(path = "/{id}")
    public Optional<Adherent> updateAdherent(@PathVariable("id") Long id, @RequestBody final Adherent newAdherent){
        logger.info("Mise à jour des informations de l'adherent");
        try {
            return this.gestionMembreMetier.majAdherent(id,newAdherent);
        } catch (MembreNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Adhérent Not Found", e);
        }
    }
}
