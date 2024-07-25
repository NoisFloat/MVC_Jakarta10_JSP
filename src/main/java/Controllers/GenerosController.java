package Controllers;

import Beans.Genero;
import Models.GenerosModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GenerosController", urlPatterns = {"/generos"})

public class GenerosController extends HttpServlet {
    protected void ProcesarPeticiones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String operacion = request.getParameter("operacion");

        if (operacion == null) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return;
        }

        switch (operacion) {
            case "insertar":
                insertarGenero(request, response);
                break;
            case "modificar":
                modificarGenero(request, response);
                break;
            case "eliminar":
                eliminarGenero(request, response);
                break;
            case "listar":
                ListarEditoriales(request, response);
                break;
            case "verDetalles":
                verDetalles(request, response);
                break;
            default:
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
                break;
        }
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProcesarPeticiones(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProcesarPeticiones(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }

    private void verDetalles(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Genero genero = null;
        GenerosModel genModel = new GenerosModel();
        String param = request.getParameter("id");
        genero = genModel.obtenerGenero(param);
        request.setAttribute("genero", genero);
        RequestDispatcher rd = request.getRequestDispatcher("/Generos/editarGeneros.jsp");
        rd.forward(request,response);
    }

    private void ListarEditoriales(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Genero> generos = null;
        GenerosModel genModel = new GenerosModel();

        generos = genModel.listarGeneros();
        request.setAttribute("pto", generos);
        RequestDispatcher rd = request.getRequestDispatcher("/Generos/listaGeneros.jsp");
        rd.forward(request, response);
    }

    private void eliminarGenero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String idGenero = (String) request.getAttribute("id");
        GenerosModel genModel = new GenerosModel();
        if(genModel.eliminarGenero(idGenero)>0){
            RequestDispatcher rd = request.getRequestDispatcher("/Generos/listaGeneros.jsp");
            rd.forward(request,response);
        }else {
            RequestDispatcher rd = request.getRequestDispatcher("/Generos/eliminarGenero.jsp");
            String errores = "Ocurrio un error en  la eliminacion";
            request.setAttribute("errores", errores);
            rd.forward(request,response);
        }

    }

    private void modificarGenero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Genero gen = new Genero();
        RequestDispatcher rd;
        GenerosModel genModel = new GenerosModel();
        String idGenero = request.getParameter("idGenero");
        gen.setIdGenero(Integer.parseInt(idGenero));
        gen.setNombreGenero(request.getParameter("nombreGenero"));
        gen.setDescripcion( request.getParameter("descripcion"));
        System.out.println(gen.getNombreGenero());
        System.out.println(gen.getDescripcion());
        System.out.println(gen.getIdGenero());

        if(genModel.modificarGenero(gen) != 0){
             response.sendRedirect("/generos?operacion=listar");
        }else {
            String errores = "Ocurrio un error en  la modificacion";
            request.setAttribute("errores", errores);
           rd = request.getRequestDispatcher("/Generos/editarGeneros.jsp");
            rd.forward(request,response);

        }
    }

    private void insertarGenero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Genero gen = new Genero();
        RequestDispatcher rd;
        GenerosModel genModel = new GenerosModel();
        String idGeneroStr = request.getParameter("id");
        int idGenero;
        try {
            idGenero = Integer.parseInt(idGeneroStr);
        } catch (NumberFormatException e) {
            // Manejar el error de conversión
            idGenero = 0; // O cualquier valor por defecto o manejo adecuado del error
        }
        gen.setIdGenero(idGenero);

        gen.setNombreGenero(request.getParameter("nombreGenero"));
        gen.setDescripcion( request.getParameter("descripcion"));

        if(genModel.insertarGeneros(gen) != 0){
            rd = request.getRequestDispatcher("/generos?operacion=listar");
        }else {
            String errores = "Ocurrio un error en  la insercion";
            request.setAttribute("errores", errores);
            rd = request.getRequestDispatcher("/Generos/nuevoGenero.jsp");
        }
        rd.forward(request,response);
    }
}
