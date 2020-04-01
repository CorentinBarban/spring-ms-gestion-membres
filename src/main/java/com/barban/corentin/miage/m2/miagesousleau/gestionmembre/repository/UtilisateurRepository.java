package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Utilisateur;

import javax.transaction.Transactional;

@Transactional
public interface UtilisateurRepository extends UtilisateurBaseRepository<Utilisateur> {
}
