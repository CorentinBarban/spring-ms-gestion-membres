package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Enseignant;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Utilisateur;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.EnseignantRepository;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionUtilisateurMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateurs/enseignants")
public class EnseignantController {

    Logger logger = LoggerFactory.getLogger(EnseignantController.class);

    @Autowired
    GestionUtilisateurMetier gestionUtilisateurMetier;

    @Autowired
    EnseignantRepository enseignantRepository;

    @PostMapping(path = "")
    public Enseignant postEnseignant(@RequestBody Enseignant enseignant) {
        logger.info("Creation d'un nouvel enseignant : " + enseignant);
        return this.gestionUtilisateurMetier.creerEnseignant(enseignant);
    }

    @GetMapping(path = "")
    public Iterable<Enseignant> getListEnseignants() {
        logger.info("Lister l'ensemble des enseignants");
        return this.gestionUtilisateurMetier.listerEnseignant();
    }

    @PutMapping(path = "/{id}")
    public Optional<Enseignant> updateEnseignant(@PathVariable("id") Long id, @RequestBody final Enseignant newEnseignant){
        logger.info("Mise à jour des informations de l'enseignant");
        return this.gestionUtilisateurMetier.majEnseignant(id,newEnseignant);
    }
}
