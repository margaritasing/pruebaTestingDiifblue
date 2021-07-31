package com.example.pruebatest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PersonajeTest {

    @Test
    public void puedeJugarBienConUnaVida() {
        // GIVEN
        int vidas = 1;
        int puntos = 0;
        Personaje personaje = new Personaje();
        personaje.setPuntos(puntos);
        personaje.setVidas(vidas);
        boolean juegaBien = true;

        // WHEN
        boolean resultado = personaje.jugar(juegaBien);

        // THEN
        assertEquals(true, resultado);
    }

    @Test
    public void noPuedeSeguirJugandoDespuesDeJugarMalConUnaVida() {
        // GIVEN
        int vidas = 1;
        int puntos = 0;
        Personaje personaje = new Personaje();
        personaje.setPuntos(puntos);
        personaje.setVidas(vidas);

        // WHEN
        boolean resultado = personaje.jugar(false);

        // THEN
        assertEquals(false, resultado);
    }

    @Test
    public void bajaLaCantidadDeVidasDespuesDeJugarMal() {
        // GIVEN
        int vidas = 10;
        Personaje personaje = new Personaje();
        personaje.setVidas(vidas);
        personaje.setPuntos(0);

        // WHEN
        boolean resultado = personaje.jugar(false);

        // THEN
        assertThat(personaje.getVidas()).isLessThan(vidas);
    }

    @Test
    public void aumentanLosPuntosCuandoJuega() {
        // Given
        Integer puntosIniciales = 100;
        Personaje personaje = new Personaje();
        personaje.setPuntos(puntosIniciales);
        personaje.setVidas(5);

        // When
        personaje.jugar(false);

        // Then
        assertThat(personaje.getPuntos()).isGreaterThan(puntosIniciales);
    }

    @Test
    public void puedeSeguirJugandoConUnaVida() {
        // Dado un contexto
        Personaje personaje = new Personaje();
        personaje.setVidas(1);

        // Si hago esto
        boolean puedeSeguirJugando = personaje.puedeSeguirJugando();

        // Espero esto
        assertTrue(puedeSeguirJugando);
    }

    @Test
    public void NoPuedeSeguirJugandoSiTieneCeroVidas() {
        // Arrange
        Personaje personaje = new Personaje();
        personaje.setVidas(0);

        // Act
        boolean puedeSeguirJugando = personaje.puedeSeguirJugando();

        // Assert
        assertFalse(puedeSeguirJugando);
    }

    @Test
    @Disabled
    public void testJugar() {
        // Arrange
        Personaje personaje = new Personaje();
        personaje.setVidas(0);
        personaje.setPuntos(1);
        boolean jugarBien = true;

        // Act
        boolean actualJugarResult = personaje.jugar(jugarBien);

        // Assert
        assertFalse(actualJugarResult);
    }

    @Test
    @Disabled
    public void testJugar2() {
        // Arrange
        Personaje personaje = new Personaje();
        personaje.setVidas(1);
        personaje.setPuntos(1);
        boolean jugarBien = false;

        // Act
        boolean actualJugarResult = personaje.jugar(jugarBien);

        // Assert
        assertFalse(actualJugarResult);
        assertEquals(0, personaje.getVidas().intValue());
    }

    @Test
    @Disabled
    public void testJugar3() {
        // Arrange
        Personaje personaje = new Personaje("Nombre", 1, 1);
        personaje.setPuntos(1);
        boolean jugarBien = false;

        // Act
        boolean actualJugarResult = personaje.jugar(jugarBien);

        // Assert
        assertFalse(actualJugarResult);
        assertEquals(0, personaje.getVidas().intValue());
    }

    @Test
    @Disabled
    public void testGetResultados() {
        // Arrange
        Personaje personaje = new Personaje();

        // Act
        String actualResultados = personaje.getResultados();

        // Assert
        assertEquals("null terminó con null puntos y null vidas.", actualResultados);
    }

    @Test
    public void testGetResultados2() {
        // Arrange
        Personaje personaje = new Personaje();

        // Act
        String actualResultados = personaje.getResultados();

        // Assert
        assertEquals("null terminó con null puntos y null vidas.", actualResultados);
    }
}