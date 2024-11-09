package mx.com.cst.webapp.jpa.service;

import jakarta.jws.WebService;
import mx.com.cst.webapp.jpa.model.Libro;

import java.util.List;

@WebService
public interface LibroServicioWeb {

    List<Libro> listar();
    Libro guardar(Libro libro);

}
