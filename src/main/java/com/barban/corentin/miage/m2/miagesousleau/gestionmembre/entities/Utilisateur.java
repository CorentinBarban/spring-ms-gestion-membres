package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Utilisateur {

    @Id
    private Long idUtilisateur;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    private String adresseMail;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String villeResidence;

    @NotNull
    private String paysResidence;

}
