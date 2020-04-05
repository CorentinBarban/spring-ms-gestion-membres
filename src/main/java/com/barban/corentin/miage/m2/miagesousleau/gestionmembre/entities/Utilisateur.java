package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",discriminatorType = DiscriminatorType.STRING)
public abstract class Utilisateur {

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
