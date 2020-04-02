package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Enseignant;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Participant;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.President;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Secretaire;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionUtilisateurMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class UtilisateurController {
    Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    GestionUtilisateurMetier gestionUtilisateurMetier;

    @PostMapping(path = "utilisateur/president")
    public President postPresident(@RequestBody President president) {
        logger.info("Creation d'un nouveau president : " + president);
        return this.gestionUtilisateurMetier.creerPresident(president);
    }

    @PostMapping(path = "utilisateur/enseignant")
    public Enseignant postEnseignant(@RequestBody Enseignant enseignant) {
        logger.info("Creation d'un nouvel enseignant : " + enseignant);
        return this.gestionUtilisateurMetier.creerEnseignant(enseignant);
    }

    @PostMapping(path = "utilisateur/secretaire")
    public Secretaire postSecretaire(@RequestBody Secretaire secretaire) {
        logger.info("Creation d'un nouveau secretaire : " + secretaire);
        return this.gestionUtilisateurMetier.creerSecretaire(secretaire);
    }

    @PostMapping(path = "utilisateur/participant")
    public Participant postParticipant(@RequestBody Participant participant) {
        logger.info("Creation d'un nouveau participant : " + participant);
        return this.gestionUtilisateurMetier.creerParticipant(participant);
    }

}
