package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.*;

import java.util.Optional;

public interface GestionUtilisateurMetier {

    President creerPresident(President president);

    Enseignant creerEnseignant(Enseignant enseignant);

    Secretaire creerSecretaire(Secretaire secretaire);

    Adherent creerAdherent(Adherent adherent);

    Iterable<Utilisateur> listerUtilisateurs();

    Iterable<Enseignant> listerEnseignant();

    Iterable<Adherent> listerAdherent();

    Optional<Enseignant> majEnseignant(Long idEnseignant, Enseignant enseignant);

    Optional<Adherent> majAdherent(Long idAdherent, Adherent newAdherent);
}
