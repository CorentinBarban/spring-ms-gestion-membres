package com.barban.corentin.miage.m2.miagesousleau.gestionmembre;

import com.barban.corentin.miage.m2.miagesousleau.gestionmembre.entities.Enseignant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionmembreApplication {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionmembreApplication.class, args);
    }

}
