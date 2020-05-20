package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;


import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.DTO.StatistiquesMembre;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.EnseignantRepository;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionStatistiqueImpl implements GestionStatistiqueMetier {

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    EnseignantRepository enseignantRepository;

    @Autowired
    GestionPaiementMetier gestionPaiementMetier;

    /**
     * Obtenir les statistisques des membres
     *
     * @return Object StatistiqueMembre
     */
    @Override
    public StatistiquesMembre obtenirStatistiqueMembres() {
        int nbMembres = (int) this.membreRepository.count();
        int nbEnseignants = (int) this.enseignantRepository.count();
        double cotisationsPrevues = nbMembres * 150;
        double cotisationsReglees = this.gestionPaiementMetier.obtenirSolde();
        return new StatistiquesMembre(nbMembres, nbEnseignants, cotisationsPrevues, cotisationsReglees);
    }
}
