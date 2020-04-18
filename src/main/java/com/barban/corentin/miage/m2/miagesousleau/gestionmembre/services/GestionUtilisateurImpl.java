package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.*;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.UtilisateurNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestionUtilisateurImpl implements GestionUtilisateurMetier {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    MembreRepository<Membre> membreRepository;

    @Autowired
    SecretaireRepository secretaireRepository;

    @Autowired
    PresidentRepository presidentRepository;

    @Autowired
    EnseignantRepository enseignantRepository;

    @Autowired
    AdherentRepository adherentRepository;


    @Override
    public President creerPresident(President president) {
        return this.presidentRepository.save(president);
    }

    @Override
    public Enseignant creerEnseignant(Enseignant enseignant) {
        return this.enseignantRepository.save(enseignant);
    }

    @Override
    public Secretaire creerSecretaire(Secretaire secretaire) {
        return this.secretaireRepository.save(secretaire);
    }

    @Override
    public Adherent creerAdherent(Adherent adherent) {
        return this.adherentRepository.save(adherent);
    }


    @Override
    public Utilisateur getUtilisateur(Long idUtilisateur) throws UtilisateurNotFoundException {
        if (this.utilisateurRepository.existsById(idUtilisateur)) {
            return this.utilisateurRepository.findById(idUtilisateur).get();
        } else {
            throw new UtilisateurNotFoundException("L'utilisateur n'existe pas");
        }
    }

    @Override
    public Membre getMembre(Long idMembre) throws UtilisateurNotFoundException {
        if (this.membreRepository.existsById(idMembre)) {
            return this.membreRepository.findById(idMembre).get();
        } else {
            throw new UtilisateurNotFoundException("Le membre n'existe pas");
        }
    }

    @Override
    public Iterable<Utilisateur> listerUtilisateurs() {
        return this.utilisateurRepository.findAll();
    }

    @Override
    public Iterable<Membre> listerMembres() {
        return this.membreRepository.findAll();
    }

    @Override
    public Iterable<Enseignant> listerEnseignant() {
        return this.enseignantRepository.findAll();
    }

    @Override
    public Iterable<Adherent> listerAdherent() {
        return this.adherentRepository.findAll();
    }

    @Override
    public Optional<Enseignant> majEnseignant(Long idEnseignant, Enseignant newEnseignant) throws UtilisateurNotFoundException {
        try {
            this.getMembre(idEnseignant);
            return this.enseignantRepository.findById(idEnseignant)
                    .map(enseignant -> {
                        if (newEnseignant.getDateCertificat() != null) {
                            enseignant.setDateCertificat(newEnseignant.getDateCertificat());
                        }
                        if (newEnseignant.getEtatAptitude() != null) {
                            enseignant.setEtatAptitude(newEnseignant.getEtatAptitude());
                        }
                        if (newEnseignant.getEtatPaiement() != null) {
                            enseignant.setEtatPaiement(newEnseignant.getEtatPaiement());
                        }
                        if (newEnseignant.getEtatInscription() != null) {
                            enseignant.setEtatInscription(newEnseignant.getEtatInscription());
                        }
                        if (newEnseignant.getNumLicence() != null) {
                            enseignant.setNumLicence(newEnseignant.getNumLicence());
                        }
                        if (enseignant.getNiveauPlonge() != newEnseignant.getNiveauPlonge() && (newEnseignant.getNiveauPlonge() > 0 && newEnseignant.getNiveauPlonge() <= 4)) {
                            enseignant.setNiveauPlonge(newEnseignant.getNiveauPlonge());
                        }
                        return this.enseignantRepository.save(enseignant);
                    });
        } catch (UtilisateurNotFoundException exp) {
            throw new UtilisateurNotFoundException("L'enseignant n'existe pas");
        }
    }

    @Override
    public Optional<Adherent> majAdherent(Long idAdherent, Adherent newAdherent) throws UtilisateurNotFoundException {
        try {
            this.getMembre(idAdherent);
            return this.adherentRepository.findById(idAdherent)
                    .map(adherent -> {
                        if (newAdherent.getDateCertificat() != null) {
                            adherent.setDateCertificat(newAdherent.getDateCertificat());
                        }
                        if (newAdherent.getEtatAptitude() != null) {
                            adherent.setEtatAptitude(newAdherent.getEtatAptitude());
                        }
                        if (newAdherent.getEtatPaiement() != null) {
                            adherent.setEtatPaiement(newAdherent.getEtatPaiement());
                        }
                        if (newAdherent.getEtatInscription() != null) {
                            adherent.setEtatInscription(newAdherent.getEtatInscription());
                        }
                        if (newAdherent.getNumLicence() != null) {
                            adherent.setNumLicence(newAdherent.getNumLicence());
                        }
                        if (newAdherent.getNiveauPlonge() != newAdherent.getNiveauPlonge() && (newAdherent.getNiveauPlonge() > 0 && newAdherent.getNiveauPlonge() <= 4)) {
                            adherent.setNiveauPlonge(newAdherent.getNiveauPlonge());
                        }
                        return this.adherentRepository.save(adherent);
                    });
        } catch (UtilisateurNotFoundException exp) {
            throw new UtilisateurNotFoundException("L'adhérent n'existe pas");
        }
    }

    @Override
    public String obtenirEtatInscription(Membre membre) throws UtilisateurNotFoundException {
        return membre.getEtatInscription().toString();
    }

}
