package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Secretaire")
public class Secretaire  extends Utilisateur{
}
