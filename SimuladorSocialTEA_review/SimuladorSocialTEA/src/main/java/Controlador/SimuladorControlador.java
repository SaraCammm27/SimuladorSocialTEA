/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Controlador;
/*Cabeza del programa*/

import Modelo.OpcionRespuesta;
import Modelo.Progreso;
import Modelo.ResultadoEvaluacion;
import Modelo.SituacionSocial;
import Modelo.Usuario;
import Persistencia.ProgresoDAO;
import Persistencia.SituacionDAO;
import Persistencia.UsuarioDAO;
import java.util.ArrayList;

public class SimuladorControlador {

    private Usuario usuarioActual;
    private Progreso progresoActual;
    private ArrayList<SituacionSocial> situaciones;

    private UsuarioDAO usuarioDAO;
    private SituacionDAO situacionDAO;
    private ProgresoDAO progresoDAO;

    public SimuladorControlador() {
        this.usuarioDAO = new UsuarioDAO();
        this.situacionDAO = new SituacionDAO();
        this.progresoDAO = new ProgresoDAO();
        this.situaciones = situacionDAO.listarTodas();
    }

    public void iniciarUsuario(String nombre, int edad) {
        Usuario usuarioExistente = usuarioDAO.buscarPorNombre(nombre);

        if (usuarioExistente != null) {
            this.usuarioActual = usuarioExistente;
        } else {
            Usuario nuevoUsuario = new Usuario(nombre, edad);
            usuarioDAO.guardar(nuevoUsuario);
            this.usuarioActual = usuarioDAO.buscarPorNombre(nombre);
        }

        cargarProgresoUsuario();
    }

    public void iniciarUsuario(String nombre) {
        iniciarUsuario(nombre, 0);
    }

    private void cargarProgresoUsuario() {
        if (usuarioActual == null) {
            return;
        }

        Progreso progreso = progresoDAO.buscarPorUsuario(usuarioActual);

        if (progreso != null) {
            this.progresoActual = progreso;
        } else {
            this.progresoActual = new Progreso(usuarioActual);
            progresoDAO.guardar(this.progresoActual);
            this.progresoActual = progresoDAO.buscarPorUsuario(usuarioActual);
        }
    }

    public ArrayList<SituacionSocial> obtenerTodasLasSituaciones() {
        if (situaciones == null || situaciones.isEmpty()) {
            situaciones = situacionDAO.listarTodas();
        }

        return situaciones;
    }

    public ArrayList<SituacionSocial> obtenerSituacionesPorCategoria(String categoria) {
        return situacionDAO.listarPorCategoria(categoria);
    }

    public ResultadoEvaluacion responder(SituacionSocial situacion, OpcionRespuesta opcion) {
        if (situacion == null) {
            return new ResultadoEvaluacion(false, "No hay una situación seleccionada.", 0);
        }

        ResultadoEvaluacion resultado = situacion.evaluarRespuesta(opcion);

        if (progresoActual != null) {
            progresoActual.registrarResultado(resultado);
            progresoDAO.actualizar(progresoActual);

            usuarioActual.setPuntajeTotal(progresoActual.getPuntajeAcumulado());
            usuarioDAO.actualizarPuntaje(usuarioActual);
        }

        return resultado;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public Progreso getProgresoActual() {
        return progresoActual;
    }

    public ArrayList<String> obtenerCategorias() {
        ArrayList<String> categorias = new ArrayList<>();

        categorias.add("Escolar");
        categorias.add("Familiar");
        categorias.add("Publica");

        return categorias;
    }
}