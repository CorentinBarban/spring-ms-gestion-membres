package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.President;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.UtilisateurNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionPaiementMetier;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionUtilisateurMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/utilisateurs/presidents")
public class PresidentController {
    Logger logger = LoggerFactory.getLogger(PresidentController.class);

    @Autowired
    GestionUtilisateurMetier gestionUtilisateurMetier;

    @Autowired
    GestionPaiementMetier gestionPaiementMetier;

    @PostMapping(path = "")
    public President postPresident(@RequestBody President president) {
        logger.info("Creation d'un nouveau president : " + president);
        return this.gestionUtilisateurMetier.creerPresident(president);
    }

    @GetMapping(path = "/solde")
    public Double getSoldeAssociation() {
        logger.info("Connaitre le solde de miage sous l'eau ");
        return this.gestionPaiementMetier.obtenirSolde();

    }
}
