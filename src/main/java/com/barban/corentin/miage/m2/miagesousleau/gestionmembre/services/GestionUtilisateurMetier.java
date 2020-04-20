package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.*;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.UtilisateurNotFoundException;

import java.util.Optional;

public interface GestionUtilisateurMetier {

    /**
     * Creer un utilisateur de type président
     * @param president
     * @return
     */
    President creerPresident(President president);

    /**
     * Creer un utilisateur de type enseignant
     * @param enseignant
     * @return
     */
    Enseignant creerEnseignant(Enseignant enseignant);

    /**
     * Creer un utilisateur de type secretaire
     * @param secretaire
     * @return
     */
    Secretaire creerSecretaire(Secretaire secretaire);

    /**
     * Creer un utilisateur de type adherent
     * @param adherent
     * @return
     */
    Adherent creerAdherent(Adherent adherent);

    /**
     * Obtenir les informations d'un utilisateur
     * @param idUtilsateur identifiant d'un utilisateur (membre, adherent, secretaire, president)
     * @return Un utilisateur
     * @throws UtilisateurNotFoundException
     */
    Utilisateur getUtilisateur(Long idUtilsateur) throws UtilisateurNotFoundException;

    /**
     * Lister l'ensemble des utilisateurs du système
     * @return Liste d'utilisateur
     */
    Iterable<Utilisateur> listerUtilisateurs();

    /**
     * Lister l'ensemble des membres du système
     * @return Liste de membre
     */
    Iterable<Membre> listerMembres();

    /**
     * Lister l'ensemble des enseignants du système
     * @return
     */
    Iterable<Enseignant> listerEnseignant();

    /**
     * Lister l'ensemble des adherents du système
     * @return
     */
    Iterable<Adherent> listerAdherent();

    /**
     * Mettre à jour les informations de l'enseignant
     * @param idEnseignant
     * @param enseignant nouvelles informations de l'enseignant
     * @return
     * @throws UtilisateurNotFoundException
     */
    Optional<Enseignant> majEnseignant(Long idEnseignant, Enseignant enseignant) throws UtilisateurNotFoundException;

    /**
     * Mettre à jour les informations de l'adhérent
     * @param idAdherent
     * @param newAdherent
     * @return nouvelles informations de l'adhérent
     * @throws UtilisateurNotFoundException
     */
    Optional<Adherent> majAdherent(Long idAdherent, Adherent newAdherent) throws UtilisateurNotFoundException;

    /**
     * Obtenir l'etat de l'inscription d'un membre
     * @param idMembre
     * @return etat d'un membre {COMPLET | INCOMPLET}
     * @throws UtilisateurNotFoundException
     */
    String obtenirEtatInscription(Long idMembre) throws UtilisateurNotFoundException;

    /**
     * Change le statut d'un membre
     * @param idMembre
     * @return
     */
    Membre changerStatut(Long idMembre, String targetClass) throws UtilisateurNotFoundException;

}
