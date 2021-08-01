package com.juegocarros.juegodecarros;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author dickdelv
 */
@SpringBootApplication
public class JuegodecarrosApplication implements CommandLineRunner {

    @Autowired
    private crearjugador crearjugador;

    public static void main(String[] args) {
        SpringApplication.run(JuegodecarrosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner reader = new Scanner(System.in);
        crearjugador.interfazprincipal();
    }

}
