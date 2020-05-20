package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.President;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionPaiementMetier;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionMembreMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membres/presidents")
public class PresidentController {
    Logger logger = LoggerFactory.getLogger(PresidentController.class);

    @Autowired
    GestionMembreMetier gestionMembreMetier;

    @Autowired
    GestionPaiementMetier gestionPaiementMetier;

    @PostMapping(path = "")
    public President postPresident(@RequestBody President president) {
        logger.info("Creation d'un nouveau president : " + president);
        return this.gestionMembreMetier.creerPresident(president);
    }

    @PreAuthorize("#oauth2.hasScope('write') and hasRole('ROLE_PRESIDENT')")
    @GetMapping(path = "/solde")
    public Double getSoldeAssociation() {
        logger.info("Connaitre le solde de miage sous l'eau ");
        return this.gestionPaiementMetier.obtenirSolde();

    }
}
