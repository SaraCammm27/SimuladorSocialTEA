/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Usuario {

    private int id;
    private String nombre;
    private int edad;
    private int puntajeTotal;

    public Usuario() {
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.puntajeTotal = 0;
    }

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.puntajeTotal = 0;
    }

    public Usuario(int id, String nombre, int edad, int puntajeTotal) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.puntajeTotal = puntajeTotal;
    }

    public void sumarPuntos(int puntos) {
        if (puntos > 0) {
            this.puntajeTotal += puntos;
        }
    }

    public void reiniciarPuntaje() {
        this.puntajeTotal = 0;
    }

    public boolean tieneEdadRegistrada() {
        return edad > 0;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        }
    }

    public void setPuntajeTotal(int puntajeTotal) {
        if (puntajeTotal >= 0) {
            this.puntajeTotal = puntajeTotal;
        }
    }

    @Override
    public String toString() {
        return nombre + " - Puntaje: " + puntajeTotal;
    }
}