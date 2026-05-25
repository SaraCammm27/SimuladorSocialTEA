/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
//Herencia de clase padre
public class SituacionEscolar extends SituacionSocial {

    private String asignatura;

    public SituacionEscolar() {
        super();
        setCategoria("Escolar");
    }

    public SituacionEscolar(String titulo, String descripcion) {
        super(titulo, descripcion, "Escolar");
    }

    public SituacionEscolar(String titulo, String descripcion, String asignatura) {
        super(titulo, descripcion, "Escolar");
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String obtenerConsejo() {
        if (asignatura != null && !asignatura.isEmpty()) {
            return "En el entorno escolar, especialmente en " + asignatura
                    + ", es importante pedir ayuda de forma clara y respetuosa.";
        }

        return "En el entorno escolar es importante pedir ayuda, respetar turnos y comunicar lo que necesitas.";
    }
}
