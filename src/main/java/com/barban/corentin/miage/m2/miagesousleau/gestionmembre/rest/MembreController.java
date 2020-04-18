package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Adherent;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Membre;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.UtilisateurNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionUtilisateurMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateurs/membres")
public class MembreController {

    Logger logger = LoggerFactory.getLogger(MembreController.class);

    @Autowired
    GestionUtilisateurMetier gestionUtilisateurMetier;

    @GetMapping(path = "")
    public Iterable<Membre> getListMembres() {
        logger.info("Lister l'ensemble des membres de l'association");
        return this.gestionUtilisateurMetier.listerMembres();
    }

    @GetMapping(path = "/{id}")
    public Membre getMembre(@PathVariable("id") Long idMembre) {
        logger.info("Lister les informations d'un membre");
        try {
            return this.gestionUtilisateurMetier.getMembre(idMembre);
        } catch (UtilisateurNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Membre Not Found", e);
        }
    }

    @GetMapping(path = "/{id}/statutinscription")
    public String getStatutInscription(@PathVariable("id") Membre membre){
        logger.info("Fournir le statut de l'inscription");
        try {
            return this.gestionUtilisateurMetier.obtenirEtatInscription(membre);
        } catch (UtilisateurNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Membre Not Found", e);
        }
    }
}
