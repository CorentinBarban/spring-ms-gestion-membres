package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Enseignant;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionUtilisateurMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilisateurs/enseignants")
public class EnseignantController {

    Logger logger = LoggerFactory.getLogger(EnseignantController.class);

    @Autowired
    GestionUtilisateurMetier gestionUtilisateurMetier;

    @PostMapping(path = "")
    public Enseignant postEnseignant(@RequestBody Enseignant enseignant) {
        logger.info("Creation d'un nouvel enseignant : " + enseignant);
        return this.gestionUtilisateurMetier.creerEnseignant(enseignant);
    }

}
