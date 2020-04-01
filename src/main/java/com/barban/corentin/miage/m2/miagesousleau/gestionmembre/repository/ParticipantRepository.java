package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Participant;
import javax.transaction.Transactional;

@Transactional
public interface ParticipantRepository extends MembreRepository<Participant> {
}
