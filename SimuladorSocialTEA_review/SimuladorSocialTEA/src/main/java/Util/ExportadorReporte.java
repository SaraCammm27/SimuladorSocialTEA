/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Modelo.Progreso;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ExportadorReporte {

    public boolean exportarProgreso(Progreso progreso, String rutaArchivo) {
        if (progreso == null || Validador.textoVacio(rutaArchivo)) {
            return false;
        }

        try (PrintWriter escritor = new PrintWriter(new FileWriter(rutaArchivo))) {
            escritor.println("REPORTE DE PROGRESO");
            escritor.println("===================");
            escritor.println();
            escritor.println(progreso.obtenerResumen());
            escritor.println();
            escritor.println("Fecha de exportacion: " + LocalDateTime.now());

            return true;
        } catch (IOException e) {
            System.out.println("Error al exportar reporte: " + e.getMessage());
            return false;
        }
    }

    public boolean exportarTexto(String contenido, String rutaArchivo) {
        if (Validador.textoVacio(contenido) || Validador.textoVacio(rutaArchivo)) {
            return false;
        }

        try (PrintWriter escritor = new PrintWriter(new FileWriter(rutaArchivo))) {
            escritor.println(contenido);
            return true;
        } catch (IOException e) {
            System.out.println("Error al exportar texto: " + e.getMessage());
            return false;
        }
    }
}