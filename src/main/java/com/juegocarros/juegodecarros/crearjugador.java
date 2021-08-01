package com.juegocarros.juegodecarros;

import org.springframework.stereotype.Component;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;

import com.juegocarros.juegodecarros.service.CarServiceImpl;
import com.juegocarros.juegodecarros.service.DriverServiceImpl;
import com.juegocarros.juegodecarros.service.TrackServiceImpl;
import com.juegocarros.juegodecarros.entity.Car;
import com.juegocarros.juegodecarros.entity.Driver;
import com.juegocarros.juegodecarros.entity.Podium;
import com.juegocarros.juegodecarros.entity.Race;
import com.juegocarros.juegodecarros.entity.Track;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author dickdelv
 */
@Component
public class crearjugador {

    Scanner reader = new Scanner(System.in);

    @Autowired
    private DriverServiceImpl driverService;

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private TrackServiceImpl trackService;

    public void interfazprincipal() {

        System.out.println("Interfaz Principal\n");
        System.out.println("1. Crear Jugador\n");
        System.out.println("2. Nuevo Juego\n");
        System.out.println("3. Salir\n");
        System.out.println("Elige una de las opciones anteriores\n");

        int opcionPrincipal = 0;
        opcionPrincipal = reader.nextInt();

        switch (opcionPrincipal) {
            case 1:
                guardarparticipante();
            case 2:
                crearJuego();
            case 3:
                exit();
                break;
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void guardarparticipante() {

        System.out.println("Crear Jugador\n");
        System.out.println("Escribe el nombre de tu jugador\n");

        String nombreJugador;
        nombreJugador = reader.next();

        //Consultar último id 
        int ultimo = driverService.latestIdDriver();
        System.out.println(ultimo);
        int nextIdDriver;
        if (ultimo <= 0) {
            nextIdDriver = 1;
        } else {
            nextIdDriver = driverService.latestIdDriver() + 1;
        }

        Driver driver = new Driver(nextIdDriver, nombreJugador); //Ajustar id
        guardarConductor(driver, nombreJugador);

    }

    public void guardarConductor(Driver driver, String name_player) {

        System.out.println("Seleccion de carros\n");

        List<Car> lista = new ArrayList<Car>();
        lista = carService.findAll();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getIdCar() + " " + lista.get(i).getBrandCar());
        }

        System.out.println("Seleccione el carro con el que desea jugar\n");

        Integer numberCar;
        numberCar = reader.nextInt();

        // datos del conductor
        driver.setIdCar(numberCar);
        driverService.Save(driver);

        System.out.println("Carro seleccionado fue " + lista.get(numberCar - 1).getBrandCar() + "\n");
        interfazprincipal();
    }

    public void crearJuego() {

        System.out.println("Nuevo Juego\n");

        System.out.println("Escribe la cantidad de conductores que van a participar en la carrera\n");

        int cantidadConductores = 0;
        cantidadConductores = reader.nextInt();

        System.out.println("Seleccion de conductor\n");

        List<Driver> listaDriversNames = new ArrayList<Driver>();
        listaDriversNames = driverService.findAll();
        for (int i = 0; i < listaDriversNames.size(); i++) {
            System.out.println(listaDriversNames.get(i).getIdPlayer() + " " + listaDriversNames.get(i).getNamePlayer() + " " + listaDriversNames.get(i).getIdCar());
        }
        
        for (int i = 1; i <= cantidadConductores; i++) {
            System.out.println("Seleccione conductor " + i + "\n");
            int conductor = reader.nextInt();
            System.out.println("Conductor seleccionado N "+ i +" es "+listaDriversNames.get(conductor-1).getNamePlayer() +"\n");
        }

        

        System.out.println("Seleccion de pista\n");
        int sel = 0;

        List<Track> pista = new ArrayList<Track>();
        pista = trackService.findAll();
        for (int i = 0; i < pista.size(); i++) {
            System.out.println(pista.get(i).getIdTrack() + " " + pista.get(i).getNameTrack()+ " " + pista.get(i).getDistanceTrack()+" Km");
        }

        System.out.println("Seleccione la pista\n");
        sel = reader.nextInt();

        System.out.println("La pista tendra una distancia de : " + pista.get(sel - 1).getDistanceTrack() + " Km. \n");

        System.out.println("Ya Podemos empezar el juego\n");

        ejecutarJuego(cantidadConductores, sel, listaDriversNames);

    }

    public void ejecutarJuego(int cantidadConductores, int distanciaPista, List<Driver> listaNombreConductores) {

        recorrerPistas(cantidadConductores, listaNombreConductores, distanciaPista);
    }

    public void recorrerPistas(int cantidadConductores, List<Driver> listaNombreConductores, int distanciaPistaKilometros) {

        int conversionDistanciaMetros = distanciaPistaKilometros * 1000;

        for (int i = 0; i < distanciaPistaKilometros; i++) {

            recorrerTurnosPorMetros(conversionDistanciaMetros, listaNombreConductores, cantidadConductores);
        }

        //Final de carrera
    }

    public void recorrerTurnosPorMetros(int conversionDistanciaMetros, List<Driver> listaNombreConductores, int cantidadConductores) {

        Podium podio = new Podium();
        List<Race> listaDriver = new ArrayList<Race>();

        int metrosAcumulados[] = new int[listaNombreConductores.size()];
        while (podio.getIdThirdPlace() == 0) {
            recorrerConductores(listaDriver, metrosAcumulados);
            for (int i = 0; i < metrosAcumulados.length; i++) {
                if (metrosAcumulados[i] >= conversionDistanciaMetros) {
                    if (podio.getIdFirstPlace() == 0) {
                        podio.setIdFirstPlace(i);//listaNombreConductores.get(i));
                    } else if (podio.getIdSecondPlace() == 0) {
                        podio.setIdSecondPlace(i);//listaNombreConductores.get(i);
                    } else if (podio.getIdThirdPlace() == 0) {
                        podio.setIdThirdPlace(i);//listaNombreConductores.get(i);
                    }
                }
            }
        }

        //Guardar podio BD
        //Imprimir podio
    }

    public void recorrerConductores(List<Race> listRace, int metrosAcumulados[]) {

        for (int i = 0; i < cantidadConductores; i++) {

            int numeroAleatorio = (int) (Math.random() * 6 + 1);
            int metrosAvanzados = numeroAleatorio * 100;
            metrosAcumulados[i] = metrosAcumulados[i] + metrosAvanzados;

            System.out.println("El conductor " + listaNombreConductores.get(i) + "sacó " + numeroAleatorio + " con el dado, avanza " + metrosAvanzados + " metros, lleva recorrido " + metrosAcumulados[i] + " metros de la pista actual hasta el momento");
        }

    }
}
