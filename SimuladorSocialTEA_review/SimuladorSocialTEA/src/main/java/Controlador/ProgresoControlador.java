/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Progreso;
import Modelo.ResultadoEvaluacion;
import Modelo.Usuario;

public class ProgresoControlador {

    private Progreso progreso;

    public ProgresoControlador() {
    }

    public ProgresoControlador(Usuario usuario) {
        this.progreso = new Progreso(usuario);
    }

    public ProgresoControlador(Progreso progreso) {
        this.progreso = progreso;
    }

    public void crearProgreso(Usuario usuario) {
        this.progreso = new Progreso(usuario);
    }

    public void registrarResultado(ResultadoEvaluacion resultado) {
        if (progreso != null && resultado != null) {
            progreso.registrarResultado(resultado);
        }
    }

    public String obtenerResumen() {
        if (progreso == null) {
            return "No hay progreso registrado.";
        }

        return progreso.obtenerResumen();
    }

    public String obtenerNivel() {
        if (progreso == null) {
            return "Sin nivel";
        }

        return progreso.getNivel();
    }

    public int obtenerPuntaje() {
        if (progreso == null) {
            return 0;
        }

        return progreso.getPuntajeAcumulado();
    }

    public int obtenerSituacionesCompletadas() {
        if (progreso == null) {
            return 0;
        }

        return progreso.getSituacionesCompletadas();
    }

    public void reiniciarProgreso() {
        if (progreso != null) {
            Usuario usuario = progreso.getUsuario();
            this.progreso = new Progreso(usuario);
        }
    }

    public Progreso getProgreso() {
        return progreso;
    }

    public void setProgreso(Progreso progreso) {
        this.progreso = progreso;
    }
}