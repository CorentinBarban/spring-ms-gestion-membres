package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.*;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.MembreNotFoundException;

import java.util.Optional;

public interface GestionMembreMetier {

    /**
     * Creer un membre de type président
     * @param president
     * @return
     */
    President creerPresident(President president);

    /**
     * Creer un membre de type enseignant
     * @param enseignant
     * @return
     */
    Enseignant creerEnseignant(Enseignant enseignant);

    /**
     * Creer un membre de type secretaire
     * @param secretaire
     * @return
     */
    Secretaire creerSecretaire(Secretaire secretaire);

    /**
     * Creer un membre de type adherent
     * @param adherent
     * @return
     */
    Adherent creerAdherent(Adherent adherent);

    /**
     * Obtenir les informations d'un membre
     * @param idMembre identifiant d'un membre (membre, adherent, secretaire, president)
     * @return Un membre
     * @throws MembreNotFoundException
     */
    Membre getMembre(Long idMembre) throws MembreNotFoundException;


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
     * @throws MembreNotFoundException
     */
    Optional<Enseignant> majEnseignant(Long idEnseignant, Enseignant enseignant) throws MembreNotFoundException;

    /**
     * Mettre à jour les informations de l'adhérent
     * @param idAdherent
     * @param newAdherent
     * @return nouvelles informations de l'adhérent
     * @throws MembreNotFoundException
     */
    Optional<Adherent> majAdherent(Long idAdherent, Adherent newAdherent) throws MembreNotFoundException;

    /**
     * Obtenir l'etat de l'inscription d'un membre
     * @param idMembre
     * @return etat d'un membre {COMPLET | INCOMPLET}
     * @throws MembreNotFoundException
     */
    String obtenirEtatInscription(Long idMembre) throws MembreNotFoundException;

    /**
     * Change le statut d'un membre
     * @param idMembre
     * @return
     */
    Membre changerStatut(Long idMembre, String targetClass) throws MembreNotFoundException;

}
