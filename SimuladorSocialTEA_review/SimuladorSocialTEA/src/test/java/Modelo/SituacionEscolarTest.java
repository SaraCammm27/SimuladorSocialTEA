/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class SituacionEscolarTest {

    @Test
    public void testEvaluarRespuestaCorrecta() {
        SituacionEscolar situacion = new SituacionEscolar(
                "Pedir ayuda",
                "No entendiste una instrucción.",
                "Matemáticas"
        );

        OpcionRespuesta opcion = new OpcionRespuesta(
                "Pido ayuda al profesor.",
                true,
                "Muy bien. Pedir ayuda es adecuado.",
                10
        );

        ResultadoEvaluacion resultado = situacion.evaluarRespuesta(opcion);

        assertTrue(resultado.isCorrecta());
        assertEquals(10, resultado.getPuntosObtenidos());
        assertTrue(resultado.getMensaje().contains("Muy bien"));
    }

    @Test
    public void testEvaluarRespuestaIncorrecta() {
        SituacionEscolar situacion = new SituacionEscolar(
                "Pedir ayuda",
                "No entendiste una instrucción.",
                "Matemáticas"
        );

        OpcionRespuesta opcion = new OpcionRespuesta(
                "Me voy del salón.",
                false,
                "Esta respuesta no es la más adecuada.",
                0
        );

        ResultadoEvaluacion resultado = situacion.evaluarRespuesta(opcion);

        assertFalse(resultado.isCorrecta());
        assertEquals(0, resultado.getPuntosObtenidos());
    }

    @Test
    public void testEvaluarRespuestaNull() {
        SituacionEscolar situacion = new SituacionEscolar(
                "Pedir ayuda",
                "No entendiste una instrucción.",
                "Matemáticas"
        );

        ResultadoEvaluacion resultado = situacion.evaluarRespuesta(null);

        assertFalse(resultado.isCorrecta());
        assertEquals(0, resultado.getPuntosObtenidos());
        assertEquals("Debe seleccionar una respuesta.", resultado.getMensaje());
    }

    @Test
    public void testObtenerConsejo() {
        SituacionEscolar situacion = new SituacionEscolar(
                "Pedir ayuda",
                "No entendiste una instrucción.",
                "Matemáticas"
        );

        assertTrue(situacion.obtenerConsejo().contains("Matemáticas"));
    }
}