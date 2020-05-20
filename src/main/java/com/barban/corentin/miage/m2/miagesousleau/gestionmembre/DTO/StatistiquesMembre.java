package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StatistiquesMembre implements Serializable {

    private Integer nbMembres;

    private Integer nbEnseignants;

    private Double cotisationsPrevues;

    private Double cotisationsReglees;

}
