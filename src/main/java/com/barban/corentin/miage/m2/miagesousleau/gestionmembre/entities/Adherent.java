package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("Adherent")
public class Adherent extends Membre {

    private String role = "ROLE_ADHERENT";

    @Builder(builderMethodName = "adherentBuilder")
    public Adherent(Long idMembre, String nom, String prenom, String adresseMail, String login, String password, String villeResidence, String paysResidence, Date dateCertificat, int niveauPlonge, String numLicence, StatutPaiement etatPaiement, StatutAptitude etatAptitude, StatutInscription etatInscription, List<Paiement> listePaiement, Boolean enabled) {
        super(idMembre, nom, prenom, adresseMail, login, password, villeResidence, paysResidence, dateCertificat, niveauPlonge, numLicence, etatPaiement, etatAptitude, etatInscription, listePaiement,enabled);
    }
}
