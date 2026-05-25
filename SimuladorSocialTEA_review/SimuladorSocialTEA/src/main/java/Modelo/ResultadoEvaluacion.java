/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class ResultadoEvaluacion {

    private boolean correcta;
    private String mensaje;
    private int puntosObtenidos;

    public ResultadoEvaluacion() {
    }

    public ResultadoEvaluacion(boolean correcta, String mensaje, int puntosObtenidos) {
        this.correcta = correcta;
        this.mensaje = mensaje;
        this.puntosObtenidos = puntosObtenidos;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setPuntosObtenidos(int puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }
}