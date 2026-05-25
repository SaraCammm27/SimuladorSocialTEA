/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
//Herencia de case padre
public class SituacionFamiliar extends SituacionSocial {

    private String familiarInvolucrado;

    public SituacionFamiliar() {
        super();
        setCategoria("Familiar");
    }

    public SituacionFamiliar(String titulo, String descripcion) {
        super(titulo, descripcion, "Familiar");
    }

    public SituacionFamiliar(String titulo, String descripcion, String familiarInvolucrado) {
        super(titulo, descripcion, "Familiar");
        this.familiarInvolucrado = familiarInvolucrado;
    }

    public String getFamiliarInvolucrado() {
        return familiarInvolucrado;
    }

    public void setFamiliarInvolucrado(String familiarInvolucrado) {
        this.familiarInvolucrado = familiarInvolucrado;
    }
//Sobrescritura
    @Override
    public String obtenerConsejo() {
        if (familiarInvolucrado != null && !familiarInvolucrado.isEmpty()) {
            return "Con " + familiarInvolucrado
                    + " es útil expresar lo que sientes con calma y escuchar también su punto de vista.";
        }

        return "En la familia es importante expresar emociones con calma, pedir espacio cuando sea necesario y escuchar a los demás.";
    }
}