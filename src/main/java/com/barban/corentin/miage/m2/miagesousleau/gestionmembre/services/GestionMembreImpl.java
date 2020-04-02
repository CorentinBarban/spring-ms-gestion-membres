package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

public class GestionMembreImpl implements GestionMembreMetier {

    @Autowired
    SecretaireRepository secretaireRepository;

    @Autowired
    PresidentRepository presidentRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    EnseignantRepository enseignantRepository;

}
