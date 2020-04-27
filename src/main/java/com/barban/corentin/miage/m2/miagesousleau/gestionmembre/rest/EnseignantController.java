package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Enseignant;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.MembreNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.EnseignantRepository;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services.GestionMembreMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/membres/enseignants")
public class EnseignantController {

    Logger logger = LoggerFactory.getLogger(EnseignantController.class);

    @Autowired
    GestionMembreMetier gestionMembreMetier;

    @Autowired
    EnseignantRepository enseignantRepository;

    @PostMapping(path = "")
    public Enseignant postEnseignant(@RequestBody Enseignant enseignant) {
        logger.info("Creation d'un nouvel enseignant : " + enseignant);
        return this.gestionMembreMetier.creerEnseignant(enseignant);
    }

    @GetMapping(path = "")
    public Iterable<Enseignant> getListEnseignants() {
        logger.info("Lister l'ensemble des enseignants");
        return this.gestionMembreMetier.listerEnseignant();
    }

    @GetMapping(path = "/{id}")
    public Enseignant getEnseignant(@PathVariable("id") Long idEnseignant) {
        logger.info("Lister les informations d'un enseignant");
        try {
            return (Enseignant) this.gestionMembreMetier.getMembre(idEnseignant);
        } catch (MembreNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping(path = "/{id}")
    public Optional<Enseignant> updateEnseignant(@PathVariable("id") Long id, @RequestBody Enseignant newEnseignant){
        logger.info("Mise à jour des informations de l'enseignant");
        try {
            return this.gestionMembreMetier.majEnseignant(id,newEnseignant);
        } catch (MembreNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
