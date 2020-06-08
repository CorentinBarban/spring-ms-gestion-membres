package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.services;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Membre;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Paiement;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.StatutAptitude;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.StatutPaiement;
import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledMembre {

    @Autowired
    MembreRepository membreRepository;

    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleTaskCheckInscription() {
        Iterable<Membre> listeMembres = this.membreRepository.findAll();
        for (Membre membre : listeMembres) {
            Date today = new Date();
            long diffInMillies = Math.abs(today.getTime() - membre.getDateCertificat().getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if(diff >= 365){
                membre.setEtatAptitude(StatutAptitude.NON_APTE);
            }else{
                membre.setEtatAptitude(StatutAptitude.APTE);
            }

            List<Paiement> paiementList = membre.getListePaiement();
            if(!paiementList.isEmpty()){
                for(Paiement paiement : paiementList){
                    diffInMillies = Math.abs(today.getTime() - paiement.getDatePaiement().getTime());
                    diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                    if(diff >= 365){
                        membre.setEtatPaiement(StatutPaiement.EN_RETARD_DE_PAIEMENT);
                    }
                }
            }
            membreRepository.save(membre);
        }
    }
}

