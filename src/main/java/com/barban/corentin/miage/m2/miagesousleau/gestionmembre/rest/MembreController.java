package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Membre;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.MembreNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionPaiementMetier;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionMembreMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/membres")
public class MembreController {

    Logger logger = LoggerFactory.getLogger(MembreController.class);

    @Autowired
    GestionMembreMetier gestionMembreMetier;

    @Autowired
    GestionPaiementMetier gestionPaiementMetier;

    @GetMapping(path = "")
    public Iterable<Membre> getListMembres() {
        logger.info("Lister l'ensemble des membres de l'association");
        return this.gestionMembreMetier.listerMembres();
    }

    @GetMapping(path = "/{id}")
    public Membre getMembre(@PathVariable("id") Long idMembre) {
        logger.info("Lister les informations d'un membre");
        try {
            return (Membre) this.gestionMembreMetier.getMembre(idMembre);
        } catch (MembreNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping(path = "/{id}/inscription")
    public String getStatutInscription(@PathVariable("id") Long idMembre) {
        logger.info("Fournir le statut de l'inscription");
        try {
            return this.gestionMembreMetier.obtenirEtatInscription(idMembre);
        } catch (MembreNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping(path = "/{id}")
    public Membre getStatutInscription(@PathVariable("id") Long idMembre, @RequestParam("statut") String targetStatut) {
        logger.info("Changer le type d'un membre");
        try {
            return this.gestionMembreMetier.changerStatut(idMembre, targetStatut);
        } catch (MembreNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
