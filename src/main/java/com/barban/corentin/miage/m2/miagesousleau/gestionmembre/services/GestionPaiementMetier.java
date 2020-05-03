package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;


import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Paiement;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.MembreNotFoundException;

public interface GestionPaiementMetier {

    /**
     * Payer la cotisation d'un membre
     *
     * @param paiement
     * @return
     * @throws MembreNotFoundException
     */
    Paiement payerCotisation(Paiement paiement) throws MembreNotFoundException;

    /**
     * Obtenir le solde de la miage sous l'eau
     *
     * @return
     */
    Double obtenirSolde();
}
