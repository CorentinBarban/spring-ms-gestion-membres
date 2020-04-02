package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Enseignant;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Participant;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.President;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Secretaire;

public interface GestionUtilisateurMetier {

    President creerPresident(President president);
    Enseignant creerEnseignant(Enseignant enseignant);
    Secretaire creerSecretaire(Secretaire secretaire);
    Participant creerParticipant(Participant participant);
}
