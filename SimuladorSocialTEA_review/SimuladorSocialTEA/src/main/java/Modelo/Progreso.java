/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;

public class Progreso {

    private int id;
    private Usuario usuario;
    private int situacionesCompletadas;
    private int puntajeAcumulado;
    private String nivel;
    private LocalDateTime fechaActualizacion;

    public Progreso() {
        this.situacionesCompletadas = 0;
        this.puntajeAcumulado = 0;
        this.nivel = "Inicial";
        this.fechaActualizacion = LocalDateTime.now();
    }

    public Progreso(Usuario usuario) {
        this.usuario = usuario;
        this.situacionesCompletadas = 0;
        this.puntajeAcumulado = 0;
        this.nivel = "Inicial";
        this.fechaActualizacion = LocalDateTime.now();
    }

    public Progreso(int id, Usuario usuario, int situacionesCompletadas, int puntajeAcumulado, String nivel) {
        this.id = id;
        this.usuario = usuario;
        this.situacionesCompletadas = situacionesCompletadas;
        this.puntajeAcumulado = puntajeAcumulado;
        this.nivel = nivel;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public void registrarResultado(ResultadoEvaluacion resultado) {
        if (resultado != null) {
            situacionesCompletadas++;
            puntajeAcumulado += resultado.getPuntosObtenidos();
            actualizarNivel();
            fechaActualizacion = LocalDateTime.now();

            if (usuario != null) {
                usuario.sumarPuntos(resultado.getPuntosObtenidos());
            }
        }
    }

    public void actualizarNivel() {
        if (puntajeAcumulado >= 80) {
            nivel = "Avanzado";
        } else if (puntajeAcumulado >= 40) {
            nivel = "Intermedio";
        } else {
            nivel = "Inicial";
        }
    }

    public double calcularPromedio() {
        if (situacionesCompletadas == 0) {
            return 0;
        }

        return (double) puntajeAcumulado / situacionesCompletadas;
    }

    public String obtenerResumen() {
        return "Usuario: " + usuario.getNombre()
                + "\nSituaciones completadas: " + situacionesCompletadas
                + "\nPuntaje acumulado: " + puntajeAcumulado
                + "\nNivel: " + nivel
                + "\nPromedio: " + calcularPromedio();
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getSituacionesCompletadas() {
        return situacionesCompletadas;
    }

    public int getPuntajeAcumulado() {
        return puntajeAcumulado;
    }

    public String getNivel() {
        return nivel;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setSituacionesCompletadas(int situacionesCompletadas) {
        if (situacionesCompletadas >= 0) {
            this.situacionesCompletadas = situacionesCompletadas;
        }
    }

    public void setPuntajeAcumulado(int puntajeAcumulado) {
        if (puntajeAcumulado >= 0) {
            this.puntajeAcumulado = puntajeAcumulado;
            actualizarNivel();
        }
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
