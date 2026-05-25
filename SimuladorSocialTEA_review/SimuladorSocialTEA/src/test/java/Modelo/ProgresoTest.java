/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProgresoTest {

    @Test
    public void testRegistrarResultado() {
        Usuario usuario = new Usuario("Laura", 15);
        Progreso progreso = new Progreso(usuario);

        ResultadoEvaluacion resultado = new ResultadoEvaluacion(
                true,
                "Respuesta adecuada.",
                10
        );

        progreso.registrarResultado(resultado);

        assertEquals(1, progreso.getSituacionesCompletadas());
        assertEquals(10, progreso.getPuntajeAcumulado());
        assertEquals(10, usuario.getPuntajeTotal());
    }

    @Test
    public void testNivelInicial() {
        Usuario usuario = new Usuario("Ana", 14);
        Progreso progreso = new Progreso(usuario);

        assertEquals("Inicial", progreso.getNivel());
    }

    @Test
    public void testNivelIntermedio() {
        Usuario usuario = new Usuario("Ana", 14);
        Progreso progreso = new Progreso(usuario);

        progreso.setPuntajeAcumulado(40);

        assertEquals("Intermedio", progreso.getNivel());
    }

    @Test
    public void testNivelAvanzado() {
        Usuario usuario = new Usuario("Ana", 14);
        Progreso progreso = new Progreso(usuario);

        progreso.setPuntajeAcumulado(80);

        assertEquals("Avanzado", progreso.getNivel());
    }

    @Test
    public void testCalcularPromedioSinSituaciones() {
        Usuario usuario = new Usuario("Ana", 14);
        Progreso progreso = new Progreso(usuario);

        assertEquals(0.0, progreso.calcularPromedio(), 0.001);
    }
}