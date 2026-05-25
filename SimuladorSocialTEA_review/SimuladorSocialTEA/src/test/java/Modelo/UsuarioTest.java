/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest {

    @Test
    public void testSumarPuntos() {
        Usuario usuario = new Usuario("Laura", 15);

        usuario.sumarPuntos(10);

        assertEquals(10, usuario.getPuntajeTotal());
    }

    @Test
    public void testNoSumarPuntosNegativos() {
        Usuario usuario = new Usuario("Carlos", 16);

        usuario.sumarPuntos(-5);

        assertEquals(0, usuario.getPuntajeTotal());
    }

    @Test
    public void testTieneEdadRegistrada() {
        Usuario usuario = new Usuario("Ana", 14);

        assertTrue(usuario.tieneEdadRegistrada());
    }
}