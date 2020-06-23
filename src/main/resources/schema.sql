create schema if not exists gestionmembre collate latin1_swedish_ci;

create table if not exists membre
(
    membre_type varchar(31) not null,
    id_membre bigint auto_increment
        primary key,
    adresse_mail varchar(255) not null,
    date_certificat date null,
    enabled bit null,
    etat_aptitude varchar(255) null,
    etat_inscription varchar(255) null,
    etat_paiement varchar(255) null,
    login varchar(255) not null,
    niveau_plonge int not null,
    nom varchar(255) not null,
    num_licence varchar(255) null,
    password varchar(100) not null,
    pays_residence varchar(255) not null,
    prenom varchar(255) not null,
    ville_residence varchar(255) not null,
    role varchar(255) null
);

create table if not exists paiement
(
    id_paiement bigint auto_increment
        primary key,
    date_paiement date null,
    iban varchar(255) null,
    somme double null,
    membre_id_membre bigint null,
    constraint fk_paiement_membre
        foreign key (membre_id_membre) references membre (id_membre)
);

