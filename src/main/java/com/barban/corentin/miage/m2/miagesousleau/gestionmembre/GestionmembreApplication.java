package com.barban.corentin.miage.m2.miagesousleau.gestionmembre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionmembreApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionmembreApplication.class, args);
    }

}
