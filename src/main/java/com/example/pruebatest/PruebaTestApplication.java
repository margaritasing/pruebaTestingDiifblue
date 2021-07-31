package com.example.pruebatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PruebaTestApplication {

    public static void main(String[] args) {
      //  SpringApplication.run(PruebaTestApplication.class, args);
        Integer vidas = 6;
        List<Personaje> personajes = List.of(
                new Personaje("Alexander", 0, vidas),
                new Personaje("Angelina", 0, vidas),
                new Personaje("Libia", 0, vidas)
        );

        for(Personaje personaje: personajes){
            Personaje personajeDespuesDeJugar = jugar(personaje);
            System.out.println(personajeDespuesDeJugar.getResultados());
            if(personajeDespuesDeJugar.puedeSeguirJugando())
                System.out.println(personaje.getNombre()+" ganó!");
            else
                System.out.println(personaje.getNombre()+" perdió!");
        }
    }

    public static Personaje jugar(Personaje personaje){
        for(int ronda = 0; ronda < 11; ronda++){
            int tipoJugada = (int) (Math.random()*100);

            if(!personaje.jugar(tipoJugada % 2 == 0)){
                return personaje;
            }
        }
        return personaje;
    }


}
