package mx.com.cst.webapp.jaxrs.repository;

import mx.com.cst.webapp.jaxrs.model.Libro;

import java.util.List;

public interface LibroRepository {

    List<Libro> listar();
    Libro guardar(Libro libro);
    Libro porId(int id);
    void eliminar(int id);

}
