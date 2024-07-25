package Controllers;

import Beans.Libro;
import Models.Conexion;
import Beans.Editorial;
import Models.EditorialesModel;
import Models.LibrosModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditorialesController", urlPatterns = {"/editoriales"})
public class EditorialesController extends HttpServlet {


    protected void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        request.setCharacterEncoding("UTF-8");

        String operacion = request.getParameter("operacion");
        switch (operacion) {
            case "insertar":
                insertarEditorial(request, response);
                break;
            case "modificar":
               Modificar(request,response);
                break;
            case "eliminar":
                eliminarEditorial(request,response);
                break;
            case "listar":
                ListarEditoriales(request,response);
                break;
            case "verDetalles":
                //Este servira para modificar los datos de una editorial
                VerDetalles(request,response);
                break;
            default:
                RequestDispatcher rd = request.getRequestDispatcher("../index.jsp");
                rd.forward(request, response);
                break;
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            procesarPeticion(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            procesarPeticion(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //                                                Funcionalidad del programa



    private void insertarEditorial(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException , SQLException {
        Editorial editorial = new Editorial();
        EditorialesModel editorialesModel = new EditorialesModel();
        editorial.setCodigoEditorial(request.getParameter("codigoEditorial"));
        editorial.setNombreEditorial(request.getParameter("nombreEditorial"));
        editorial.setTelefono(request.getParameter("telefono"));
        editorial.setContacto(request.getParameter("contacto"));
        if(editorialesModel.insertarEditorial(editorial) >= 1){
            request.getSession().setAttribute("exito", "Editorial modificado exitosamente");
            response.sendRedirect(request.getContextPath() +"/editoriales?operacion=listar");

        }
        else {
            request.setAttribute("errores","Verifica la informacion ");
        }
    }
    private void ListarEditoriales(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException , SQLException {
        EditorialesModel editorialesModel = new EditorialesModel();
        List<Editorial> editoriales = editorialesModel.listarEditoriales();
        request.setAttribute("editoriales", editoriales);
        request.getRequestDispatcher("/editoriales/listaEditoriales.jsp").forward(request, response);
    }

    private void VerDetalles(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Editorial editorial = null;
        EditorialesModel editorialesModel = new EditorialesModel();
        String param = request.getParameter("id");
        editorial = editorialesModel.obtenerEditorial(param);
        request.setAttribute("editorial", editorial);
        request.getRequestDispatcher("/editoriales/editarEditorial.jsp").forward(request,response);
    }

    private void Modificar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Editorial editorial = new Editorial();
        EditorialesModel editorialesModel = new EditorialesModel();
        editorial.setCodigoEditorial(request.getParameter("codigoEditorial"));
        editorial.setNombreEditorial(request.getParameter("nombreEditorial"));
        editorial.setTelefono(request.getParameter("telefono"));
        editorial.setContacto(request.getParameter("contacto"));
        if(editorialesModel.modificarEditorial(editorial) >= 1){
            request.getSession().setAttribute("exito", "Editorial modificado exitosamente");
            response.sendRedirect(request.getContextPath() +"/editoriales?operacion=listar");

        }
        else {
            request.setAttribute("errores","Verifica la informacion ");
        }

    }

    private void eliminarEditorial(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        EditorialesModel editorialesModel = new EditorialesModel();
        String id = request.getParameter("id");
        if (editorialesModel.eliminarEditorial(id)> 0){
            return;
        }

    }



}
