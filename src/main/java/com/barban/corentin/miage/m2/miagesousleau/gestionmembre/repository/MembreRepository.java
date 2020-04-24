package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Membre;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;


@Transactional
public interface MembreRepository extends MembreBaseRepository<Membre>{
}
