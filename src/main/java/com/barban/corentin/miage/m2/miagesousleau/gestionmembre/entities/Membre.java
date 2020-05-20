package com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "membre_type", discriminatorType = DiscriminatorType.STRING)
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMembre;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    private String adresseMail;

    @NotNull
    private String login;

    @NotNull
    @Column(length = 100)
    private String password;

    @NotNull
    private String villeResidence;

    @NotNull
    private String paysResidence;

    @Temporal(TemporalType.DATE)
    private Date dateCertificat;

    @Min(value = 1, message = "Le niveau ne peut pas être inférieur à 1")
    @Max(value = 5, message = "Le niveau ne peut pas être supérieur à 5")
    private int niveauPlonge;

    private String numLicence;

    @Enumerated(EnumType.STRING)
    private StatutPaiement etatPaiement;

    @Enumerated(EnumType.STRING)
    private StatutAptitude etatAptitude;

    @Enumerated(EnumType.STRING)
    private StatutInscription etatInscription;

    @OneToMany(mappedBy = "membre")
    @JsonIgnoreProperties("membre")
    private List<Paiement> listePaiement;

    private Boolean enabled = true;

}
