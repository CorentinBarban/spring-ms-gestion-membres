package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Membre;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Paiement;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.UtilisateurNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.MembreRepository;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.PaiementRepository;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.rest.MembreController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionPaiementImpl implements GestionPaiementMetier {

    @Autowired
    GestionUtilisateurMetier gestionUtilisateurMetier;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    PaiementRepository paiementRepository;


    @Override
    public Paiement payerCotisation(Paiement paiement) throws UtilisateurNotFoundException {
        try {
            Membre membre = (Membre) this.gestionUtilisateurMetier.getUtilisateur(paiement.getMembre().getIdUtilisateur());
            membre.getListePaiement().add(paiement);
            return this.paiementRepository.save(paiement);
        } catch (UtilisateurNotFoundException exp) {
            throw new UtilisateurNotFoundException("Le membre n'existe pas");
        }
    }

    @Override
    public Double obtenirSolde() {
        Iterable<Paiement> listePaiement = this.paiementRepository.findAll();
        Double solde = 0.0;
        for (Paiement paiement : listePaiement) {
            solde += paiement.getSomme();
        }
        return solde;
    }
}
