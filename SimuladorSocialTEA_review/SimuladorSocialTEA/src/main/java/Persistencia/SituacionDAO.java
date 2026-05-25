/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.OpcionRespuesta;
import Modelo.SituacionEscolar;
import Modelo.SituacionFamiliar;
import Modelo.SituacionPublica;
import Modelo.SituacionSocial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SituacionDAO {

    public ArrayList<SituacionSocial> listarTodas() {
        ArrayList<SituacionSocial> situaciones = new ArrayList<>();
        String sql = "SELECT * FROM situaciones";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SituacionSocial situacion = crearSituacionDesdeResultSet(rs);
                cargarOpciones(situacion);
                situaciones.add(situacion);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar situaciones: " + e.getMessage());
        }

        return situaciones;
    }

    public ArrayList<SituacionSocial> listarPorCategoria(String categoria) {
        ArrayList<SituacionSocial> situaciones = new ArrayList<>();
        String sql = "SELECT * FROM situaciones WHERE categoria = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, categoria);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SituacionSocial situacion = crearSituacionDesdeResultSet(rs);
                cargarOpciones(situacion);
                situaciones.add(situacion);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar situaciones por categoria: " + e.getMessage());
        }

        return situaciones;
    }

    public SituacionSocial buscarPorId(int idSituacion) {
        String sql = "SELECT * FROM situaciones WHERE id_situacion = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idSituacion);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                SituacionSocial situacion = crearSituacionDesdeResultSet(rs);
                cargarOpciones(situacion);
                return situacion;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar situacion: " + e.getMessage());
        }

        return null;
    }

    //Polimorfismo
    private SituacionSocial crearSituacionDesdeResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_situacion");
        String titulo = rs.getString("titulo");
        String descripcion = rs.getString("descripcion");
        String categoria = rs.getString("categoria");
        String detalle = rs.getString("detalle");

        SituacionSocial situacion;

        if (categoria.equalsIgnoreCase("Escolar")) {
            situacion = new SituacionEscolar(titulo, descripcion, detalle);
        } else if (categoria.equalsIgnoreCase("Familiar")) {
            situacion = new SituacionFamiliar(titulo, descripcion, detalle);
        } else {
            situacion = new SituacionPublica(titulo, descripcion, detalle);
        }

        situacion.setId(id);

        return situacion;
    }

    private void cargarOpciones(SituacionSocial situacion) {
        String sql = "SELECT * FROM opciones_respuesta WHERE id_situacion = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, situacion.getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OpcionRespuesta opcion = new OpcionRespuesta(
                        rs.getInt("id_opcion"),
                        rs.getString("texto"),
                        rs.getBoolean("adecuada"),
                        rs.getString("retroalimentacion"),
                        rs.getInt("puntos")
                );

                situacion.agregarOpcion(opcion);
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar opciones: " + e.getMessage());
        }
    }
}