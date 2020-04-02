package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    private String iban;

    private Double somme;

    @Temporal(TemporalType.DATE)
    private Date datePaiement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("listePaiement")
    private Membre membre;
}
