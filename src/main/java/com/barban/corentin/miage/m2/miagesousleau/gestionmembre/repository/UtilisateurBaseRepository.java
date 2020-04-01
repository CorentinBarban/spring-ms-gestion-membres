package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface UtilisateurBaseRepository<T extends Utilisateur> extends CrudRepository<T,Long> {
}

