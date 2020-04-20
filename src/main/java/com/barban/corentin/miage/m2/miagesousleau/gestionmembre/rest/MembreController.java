package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Adherent;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Membre;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Paiement;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.UtilisateurNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionPaiementMetier;
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

    @Autowired
    GestionPaiementMetier gestionPaiementMetier;

    @GetMapping(path = "")
    public Iterable<Membre> getListMembres() {
        logger.info("Lister l'ensemble des membres de l'association");
        return this.gestionUtilisateurMetier.listerMembres();
    }

    @GetMapping(path = "/{id}")
    public Membre getMembre(@PathVariable("id") Long idMembre) {
        logger.info("Lister les informations d'un membre");
        try {
            return (Membre) this.gestionUtilisateurMetier.getUtilisateur(idMembre);
        } catch (UtilisateurNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Membre Not Found", e);
        }
    }

    @GetMapping(path = "/{id}/inscription")
    public String getStatutInscription(@PathVariable("id") Long idMembre){
        logger.info("Fournir le statut de l'inscription");
        try {
            return this.gestionUtilisateurMetier.obtenirEtatInscription(idMembre);
        } catch (UtilisateurNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Membre Not Found", e);
        }
    }

    @PutMapping(path = "/{id}/{statut}")
    public Membre getStatutInscription(@PathVariable("id") Long idMembre ,@PathVariable("statut") String targetStatut){
        logger.info("Changer le type d'un membre");
        try {
            return this.gestionUtilisateurMetier.changerStatut(idMembre,targetStatut);
        } catch (UtilisateurNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Membre Not Found", e);
        }
    }
}
