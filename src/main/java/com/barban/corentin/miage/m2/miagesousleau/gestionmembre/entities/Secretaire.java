package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("Secretaire")
public class Secretaire extends Utilisateur {

    @Builder(builderMethodName = "secretaireBuilder")
    public Secretaire(Long idUtilisateur, String nom, String prenom, String adresseMail, String login, String password, String villeResidence, String paysResidence) {
        super(idUtilisateur, nom, prenom, adresseMail, login, password, villeResidence, paysResidence);
    }
}
