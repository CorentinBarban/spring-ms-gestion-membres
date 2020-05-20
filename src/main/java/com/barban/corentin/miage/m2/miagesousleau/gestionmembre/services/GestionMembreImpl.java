package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.*;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.exceptions.MembreNotFoundException;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class GestionMembreImpl implements GestionMembreMetier {

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    SecretaireRepository secretaireRepository;

    @Autowired
    PresidentRepository presidentRepository;

    @Autowired
    EnseignantRepository enseignantRepository;

    @Autowired
    AdherentRepository adherentRepository;

    @PersistenceContext
    EntityManager em;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    public President creerPresident(President president) {
        String hashPwd = passwordEncoder.encode(president.getPassword());
        president.setPassword(hashPwd);
        return this.presidentRepository.save(president);
    }

    @Override
    public Enseignant creerEnseignant(Enseignant enseignant) {
        String hashPwd = passwordEncoder.encode(enseignant.getPassword());
        enseignant.setPassword(hashPwd);
        return this.enseignantRepository.save(enseignant);
    }

    @Override
    public Secretaire creerSecretaire(Secretaire secretaire) {
        String hashPwd = passwordEncoder.encode(secretaire.getPassword());
        secretaire.setPassword(hashPwd);
        return this.secretaireRepository.save(secretaire);
    }

    @Override
    public Adherent creerAdherent(Adherent adherent) {
        String hashPwd = passwordEncoder.encode(adherent.getPassword());
        adherent.setPassword(hashPwd);
        return this.adherentRepository.save(adherent);
    }


    @Override
    public Membre getMembre(Long idMembre) throws MembreNotFoundException {
        if (this.membreRepository.existsById(idMembre)) {
            return this.membreRepository.findById(idMembre).get();
        } else {
            throw new MembreNotFoundException("Le membre n'existe pas");
        }
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
    public Optional<Enseignant> majEnseignant(Long idEnseignant, Enseignant newEnseignant) throws MembreNotFoundException {
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
        } catch (MembreNotFoundException exp) {
            throw new MembreNotFoundException("L'enseignant n'existe pas");
        }
    }

    @Override
    public Optional<Adherent> majAdherent(Long idAdherent, Adherent newAdherent) throws MembreNotFoundException {
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
        } catch (MembreNotFoundException exp) {
            throw new MembreNotFoundException("L'adhérent n'existe pas");
        }
    }

    @Override
    public String obtenirEtatInscription(Long idMembre) throws MembreNotFoundException {
        try {
            Membre m = this.getMembre(idMembre);
            return m.getEtatInscription().toString();
        } catch (MembreNotFoundException exp) {
            throw new MembreNotFoundException("L'adhérent n'existe pas");
        }

    }

    @Override
    public Membre changerStatut(Long idMembre, String targetClass) throws MembreNotFoundException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Membre membre = this.getMembre(idMembre);
            TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
            switch (targetClass) {
                case "ADHERENT":
                    transactionTemplate.execute(transactionStatus -> {
                        em.createQuery("UPDATE Membre SET membre_type = ?1 WHERE id_membre = ?2")
                                .setParameter(1, "Adherent")
                                .setParameter(2, idMembre)
                                .executeUpdate();
                        transactionStatus.flush();
                        return null;
                    });
                    break;
                case "ENSEIGNANT":

                    transactionTemplate.execute(transactionStatus -> {
                        em.createQuery("UPDATE Membre SET membre_type = ?1 WHERE id_membre = ?2")
                                .setParameter(1, "Enseignant")
                                .setParameter(2, idMembre)
                                .executeUpdate();
                        transactionStatus.flush();
                        return null;
                    });
                    break;
                default:
                    throw new IllegalStateException();
            }
            return membre;
        } catch (MembreNotFoundException e) {
            throw new MembreNotFoundException("L'adhérent n'existe pas");
        }
    }

}
