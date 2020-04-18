package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.*;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.UtilisateurNotFoundException;

import java.util.Optional;

public interface GestionUtilisateurMetier {

    President creerPresident(President president);

    Enseignant creerEnseignant(Enseignant enseignant);

    Secretaire creerSecretaire(Secretaire secretaire);

    Adherent creerAdherent(Adherent adherent);

    Utilisateur getUtilisateur(Long idUtilsateur) throws UtilisateurNotFoundException;

    Membre getMembre(Long idMembre) throws UtilisateurNotFoundException;

    Iterable<Utilisateur> listerUtilisateurs();

    Iterable<Membre> listerMembres();

    Iterable<Enseignant> listerEnseignant();

    Iterable<Adherent> listerAdherent();

    Optional<Enseignant> majEnseignant(Long idEnseignant, Enseignant enseignant) throws UtilisateurNotFoundException;

    Optional<Adherent> majAdherent(Long idAdherent, Adherent newAdherent) throws UtilisateurNotFoundException;

    String obtenirEtatInscription(Membre membre) throws UtilisateurNotFoundException;

}
