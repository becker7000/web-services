package mx.com.cst.webapp.jaxrs.service;

import jakarta.ejb.Local;
import mx.com.cst.webapp.jaxrs.model.Libro;

import java.util.List;
import java.util.Optional;

@Local
public interface LibroService {

    List<Libro> listar();
    Libro guardar(Libro libro);
    Optional<Libro> porId(int id);
    void eliminar(int id);

}
