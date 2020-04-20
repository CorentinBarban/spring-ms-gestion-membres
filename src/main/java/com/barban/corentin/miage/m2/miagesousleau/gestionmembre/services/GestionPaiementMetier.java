package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;


import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Paiement;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.UtilisateurNotFoundException;

public interface GestionPaiementMetier {

    /**
     * Payer la cotisation d'un membre
     * @param paiement
     * @return
     * @throws UtilisateurNotFoundException
     */
    Paiement payerCotisation(Paiement paiement) throws UtilisateurNotFoundException;

    /**
     * Obtenir le solde de la miage sous l'eau
     * @return
     */
    Double obtenirSolde();
}
