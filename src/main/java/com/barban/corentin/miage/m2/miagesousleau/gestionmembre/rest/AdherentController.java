package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Enseignant;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Adherent;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionUtilisateurMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/utilisateurs/adherents")
public class AdherentController {

    Logger logger = LoggerFactory.getLogger(AdherentController.class);

    @Autowired
    GestionUtilisateurMetier gestionUtilisateurMetier;

    @PostMapping(path = "")
    public Adherent postAdherent(@RequestBody Adherent adherent) {
        logger.info("Creation d'un nouveau participant : " + adherent);
        return this.gestionUtilisateurMetier.creerAdherent(adherent);
    }

    @GetMapping(path = "")
    public Iterable<Adherent> getListAdherent() {
        logger.info("Lister l'ensemble des adherents");
        return this.gestionUtilisateurMetier.listerAdherent();
    }

    @PutMapping(path = "/{id}")
    public Optional<Adherent> updateEnseignant(@PathVariable("id") Long id, @RequestBody final Adherent newAdherent){
        logger.info("Mise à jour des informations de l'adherent");
        return this.gestionUtilisateurMetier.majAdherent(id,newAdherent);
    }
}
