package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Secretaire;

import javax.transaction.Transactional;

@Transactional
public interface SecretaireRepository extends MembreBaseRepository<Secretaire> {
}
