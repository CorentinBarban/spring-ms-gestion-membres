package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Enseignant;

import javax.transaction.Transactional;

@Transactional
public interface EnseignantRepository extends MembreBaseRepository<Enseignant>{
}
