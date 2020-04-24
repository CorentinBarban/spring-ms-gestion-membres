package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Adherent;
import javax.transaction.Transactional;

@Transactional
public interface AdherentRepository extends MembreBaseRepository<Adherent> {
}
