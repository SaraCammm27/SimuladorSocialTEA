/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
//Herencia de clase Padre
public class SituacionPublica extends SituacionSocial {

    private String lugar;

    public SituacionPublica() {
        super();
        setCategoria("Publica");
    }

    public SituacionPublica(String titulo, String descripcion) {
        super(titulo, descripcion, "Publica");
    }

    public SituacionPublica(String titulo, String descripcion, String lugar) {
        super(titulo, descripcion, "Publica");
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
//Sobrescritura
    @Override
    public String obtenerConsejo() {
        if (lugar != null && !lugar.isEmpty()) {
            return "En lugares como " + lugar
                    + " es recomendable mantener la calma, pedir ayuda si la necesitas y respetar las normas del espacio.";
        }

        return "En espacios públicos es importante mantener la calma, seguir normas básicas y pedir ayuda a una persona de confianza si es necesario.";
    }
}