package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Paiement {

    @Id
    private Long idPaiement;

    @NotNull
    private String iban;

    @NotNull
    private Double somme;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date datePaiement;

    @NotNull
    @ManyToOne
    private Membre membre;
}
