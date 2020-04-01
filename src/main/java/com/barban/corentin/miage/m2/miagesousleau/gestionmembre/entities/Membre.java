package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;


@Entity
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
    private List<Paiement> listPaiement;
}
