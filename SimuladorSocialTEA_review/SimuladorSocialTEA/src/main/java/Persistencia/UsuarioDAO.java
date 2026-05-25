/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean guardar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, edad, puntaje_total) VALUES (?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getEdad());
            ps.setInt(3, usuario.getPuntajeTotal());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e.getMessage());
            return false;
        }
    }

    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getInt("puntaje_total")
                );

                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
        }

        return null;
    }

    public Usuario buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM usuarios WHERE nombre = ? LIMIT 1";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getInt("puntaje_total")
                );

                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar usuario por nombre: " + e.getMessage());
        }

        return null;
    }

    public boolean actualizarPuntaje(Usuario usuario) {
        String sql = "UPDATE usuarios SET puntaje_total = ? WHERE id_usuario = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, usuario.getPuntajeTotal());
            ps.setInt(2, usuario.getId());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar puntaje: " + e.getMessage());
            return false;
        }
    }
}