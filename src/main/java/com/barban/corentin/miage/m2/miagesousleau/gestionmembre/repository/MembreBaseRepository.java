package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Membre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface MembreBaseRepository<T extends Membre> extends CrudRepository<T,Long> {

}

