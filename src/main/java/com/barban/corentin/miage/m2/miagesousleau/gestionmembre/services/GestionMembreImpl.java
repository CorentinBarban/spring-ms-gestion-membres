package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.MembreRepository;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.SecretaireRepository;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GestionMembreImpl implements GestionMembreMetier {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    SecretaireRepository secretaireRepository;

}
