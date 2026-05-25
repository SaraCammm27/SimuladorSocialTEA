/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
//Clase padre 
import java.util.ArrayList;
//Clase Abstracta
public abstract class SituacionSocial implements Evaluable {

    private int id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private ArrayList<OpcionRespuesta> opciones;

    public SituacionSocial() {
        this.opciones = new ArrayList<>();
    }

    public SituacionSocial(String titulo, String descripcion, String categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.opciones = new ArrayList<>();
    }

    public SituacionSocial(int id, String titulo, String descripcion, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.opciones = new ArrayList<>();
    }

    public void agregarOpcion(OpcionRespuesta opcion) {
        if (opcion != null) {
            opciones.add(opcion);
        }
    }

    @Override
    public ResultadoEvaluacion evaluarRespuesta(OpcionRespuesta opcion) {
        if (opcion == null) {
            return new ResultadoEvaluacion(false, "Debe seleccionar una respuesta.", 0);
        }

        String mensaje = opcion.getRetroalimentacion() + "\n\nConsejo: " + obtenerConsejo();

        return new ResultadoEvaluacion(
                opcion.isAdecuada(),
                mensaje,
                opcion.getPuntos()
        );
    }

    public abstract String obtenerConsejo();

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public ArrayList<OpcionRespuesta> getOpciones() {
        return opciones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setOpciones(ArrayList<OpcionRespuesta> opciones) {
        this.opciones = opciones;
    }

    @Override
    public String toString() {
        return titulo;
    }
}