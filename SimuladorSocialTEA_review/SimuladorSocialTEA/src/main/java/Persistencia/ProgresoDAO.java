/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Progreso;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgresoDAO {

    public boolean guardar(Progreso progreso) {
        String sql = "INSERT INTO progreso (id_usuario, situaciones_completadas, puntaje_acumulado, nivel) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, progreso.getUsuario().getId());
            ps.setInt(2, progreso.getSituacionesCompletadas());
            ps.setInt(3, progreso.getPuntajeAcumulado());
            ps.setString(4, progreso.getNivel());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar progreso: " + e.getMessage());
            return false;
        }
    }

    public Progreso buscarPorUsuario(Usuario usuario) {
        String sql = "SELECT * FROM progreso WHERE id_usuario = ? ORDER BY id_progreso DESC LIMIT 1";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, usuario.getId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Progreso progreso = new Progreso(
                        rs.getInt("id_progreso"),
                        usuario,
                        rs.getInt("situaciones_completadas"),
                        rs.getInt("puntaje_acumulado"),
                        rs.getString("nivel")
                );

                return progreso;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar progreso: " + e.getMessage());
        }

        return null;
    }

    public boolean actualizar(Progreso progreso) {
        String sql = "UPDATE progreso SET situaciones_completadas = ?, puntaje_acumulado = ?, nivel = ?, fecha_actualizacion = CURRENT_TIMESTAMP WHERE id_progreso = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, progreso.getSituacionesCompletadas());
            ps.setInt(2, progreso.getPuntajeAcumulado());
            ps.setString(3, progreso.getNivel());
            ps.setInt(4, progreso.getId());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar progreso: " + e.getMessage());
            return false;
        }
    }

    public boolean guardarOActualizar(Progreso progreso) {
        if (progreso.getId() == 0) {
            return guardar(progreso);
        } else {
            return actualizar(progreso);
        }
    }
}