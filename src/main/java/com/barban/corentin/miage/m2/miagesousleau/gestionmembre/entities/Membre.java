package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Inheritance
@NamedNativeQuery(name="Customer.changeCustomerType",
        query="UPDATE utilisateur SET user_type = ? WHERE id_utilisateur = ?")
public class Membre extends Utilisateur {

    @Temporal(TemporalType.DATE)
    private Date dateCertificat;

    @Min(value = 1, message = "Le niveau ne peut pas être inférieur à 1")
    @Max(value = 5, message = "Le niveau ne peut pas être supérieur à 5")
    private int niveauPlonge;

    private String numLicence;

    @Enumerated(EnumType.STRING)
    private StatutPaiement etatPaiement;

    @Enumerated(EnumType.STRING)
    private StatutAptitude etatAptitude;

    @Enumerated(EnumType.STRING)
    private StatutInscription etatInscription;

    @OneToMany(mappedBy = "membre")
    @JsonIgnoreProperties("membre")
    private List<Paiement> listePaiement;

    @Builder(builderMethodName = "membreBuilder")
    public Membre(Long idUtilisateur, String nom, String prenom, String adresseMail, String login, String password, String villeResidence, String paysResidence, Date dateCertificat, String numLicence, StatutPaiement etatPaiement, StatutAptitude etatAptitude, StatutInscription etatInscription,List<Paiement> listePaiement) {
        super(idUtilisateur, nom, prenom, adresseMail, login, password, villeResidence, paysResidence);
        this.dateCertificat = dateCertificat;
        this.numLicence = numLicence;
        this.etatAptitude = etatAptitude;
        this.etatPaiement = etatPaiement;
        this.etatInscription = etatInscription;
        this.listePaiement = listePaiement;
    }

}
