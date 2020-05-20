package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.DTO.StatistiquesMembre;

public interface GestionStatistiqueMetier {

    /**
     * Obtenir les statistisques des membres
     *
     * @return Object StatistiqueMembre
     */
    StatistiquesMembre obtenirStatistiqueMembres();
}
