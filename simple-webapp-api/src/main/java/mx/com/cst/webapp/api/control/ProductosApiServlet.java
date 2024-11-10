package mx.com.cst.webapp.api.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.cst.webapp.api.model.Producto;
import mx.com.cst.webapp.api.service.ProductoService;
import mx.com.cst.webapp.api.service.ProductoServiceImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos-api")
public class ProductosApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProductoService productoService = new ProductoServiceImp();
        List<Producto> productos = productoService.listarProductos();

        // Mapeamos la lista de productos a json
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(productos);

        // Ajustamos en la respuesta un formato json
        resp.setContentType("application/json");
        resp.getWriter().write(json);

    }

    // Atajo: alt + ins
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletInputStream jsonStream = req.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        Producto producto = objectMapper.readValue(jsonStream,Producto.class);

        resp.setContentType("text/html; charset=UTF-8");

        try(PrintWriter salida = resp.getWriter()){

            // Atajo: ctrl + d
            salida.println("<!DOCTYPE html>");
            salida.println("<html>");
            salida.println("<head>");
            salida.println("    <meta charset=\"UTF-8\">");
            salida.println("    <title>Productos</title>");
            salida.println("</head>");
            salida.println("<body>");
            salida.println("    <h1>Detalles de los productos</h1>");
            salida.println("    <ul>");
            salida.println("        <li>Nombre: "+producto.getNombre()+"</li>");
            salida.println("        <li>Descripción: "+producto.getDescripcion()+"</li>");
            salida.println("        <li>Precio: $ "+String.format("%.2f",producto.getPrecio())+"</li>");
            salida.println("    </ul>");
            salida.println("</body>");
            salida.println("</html>");

        }

    }



}
