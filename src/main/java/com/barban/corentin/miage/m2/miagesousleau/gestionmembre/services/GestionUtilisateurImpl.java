package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Enseignant;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Participant;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.President;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Secretaire;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionUtilisateurImpl implements GestionUtilisateurMetier {

    @Autowired
    SecretaireRepository secretaireRepository;

    @Autowired
    PresidentRepository presidentRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    EnseignantRepository enseignantRepository;

    @Override
    public President creerPresident(President president) {
        return this.presidentRepository.save(president);
    }

    @Override
    public Enseignant creerEnseignant(Enseignant enseignant) {
        return this.enseignantRepository.save(enseignant);
    }

    @Override
    public Secretaire creerSecretaire(Secretaire secretaire) {
        return this.secretaireRepository.save(secretaire);
    }

    @Override
    public Participant creerParticipant(Participant participant) {
        return this.participantRepository.save(participant);
    }
}
