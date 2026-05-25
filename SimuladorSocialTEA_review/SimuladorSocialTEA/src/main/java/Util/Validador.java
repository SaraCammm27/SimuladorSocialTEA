/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

public class Validador {

    public static boolean textoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean nombreValido(String nombre) {
        return !textoVacio(nombre) && nombre.trim().length() >= 2;
    }

    public static boolean edadValida(int edad) {
        return edad >= 0 && edad <= 120;
    }

    public static boolean opcionSeleccionada(int indice) {
        return indice >= 0;
    }

    public static String limpiarTexto(String texto) {
        if (texto == null) {
            return "";
        }

        return texto.trim();
    }
}