package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Utilisateur;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.UtilisateurNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionUtilisateurMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    GestionUtilisateurMetier gestionUtilisateurMetier;

    @GetMapping(path = "")
    public Iterable<Utilisateur> getListUtilisateurs() {
        logger.info("Lister l'ensemble des utilisateurs");
        return this.gestionUtilisateurMetier.listerUtilisateurs();
    }

    @GetMapping(path = "/{id}")
    public Utilisateur getUtilisateur(@PathVariable("id") Long idUtilisateur) {
        logger.info("Lister les informations d'un utilisateur");
        try {
            return this.gestionUtilisateurMetier.getUtilisateur(idUtilisateur);
        } catch (UtilisateurNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Utilisateur Not Found", e);
        }
    }

}
