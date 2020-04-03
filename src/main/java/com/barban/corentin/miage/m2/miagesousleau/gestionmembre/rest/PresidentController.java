package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.President;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionUtilisateurMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilisateurs/presidents")
public class PresidentController {
    Logger logger = LoggerFactory.getLogger(PresidentController.class);

    @Autowired
    GestionUtilisateurMetier gestionUtilisateurMetier;

    @PostMapping(path = "")
    public President postPresident(@RequestBody President president) {
        logger.info("Creation d'un nouveau president : " + president);
        return this.gestionUtilisateurMetier.creerPresident(president);
    }
}
