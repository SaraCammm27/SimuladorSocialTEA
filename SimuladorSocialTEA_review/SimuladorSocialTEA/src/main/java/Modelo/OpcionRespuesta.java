/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class OpcionRespuesta {

    private int id;
    private String texto;
    private boolean adecuada;
    private String retroalimentacion;
    private int puntos;

    public OpcionRespuesta() {
    }

    public OpcionRespuesta(String texto, boolean adecuada, String retroalimentacion, int puntos) {
        this.texto = texto;
        this.adecuada = adecuada;
        this.retroalimentacion = retroalimentacion;
        this.puntos = puntos;
    }

    public OpcionRespuesta(int id, String texto, boolean adecuada, String retroalimentacion, int puntos) {
        this.id = id;
        this.texto = texto;
        this.adecuada = adecuada;
        this.retroalimentacion = retroalimentacion;
        this.puntos = puntos;
    }

    public boolean esAdecuada() {
        return adecuada;
    }

    public int obtenerPuntos() {
        return puntos;
    }

    public String obtenerRetroalimentacion() {
        return retroalimentacion;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isAdecuada() {
        return adecuada;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setAdecuada(boolean adecuada) {
        this.adecuada = adecuada;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return texto;
    }
}