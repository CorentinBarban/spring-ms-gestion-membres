package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Membre;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Secretaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;

@NoRepositoryBean
public interface MembreRepository<T extends Membre> extends UtilisateurBaseRepository<T>{
}