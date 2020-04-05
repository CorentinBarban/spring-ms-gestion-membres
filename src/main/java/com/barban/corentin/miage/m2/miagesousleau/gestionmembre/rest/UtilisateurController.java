package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Utilisateur;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionUtilisateurMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public Utilisateur getUtilisateur(@PathVariable("id") Utilisateur utilisateur) {
        logger.info("Lister les informations d'un utilisateur");
        return utilisateur;
    }

}
