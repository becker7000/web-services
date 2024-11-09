package mx.com.cst.webapp.jpa.repository;

import mx.com.cst.webapp.jpa.model.Libro;

import java.util.List;

public interface LibroRepository {

    List<Libro> listarLibros();
    Libro guardar(Libro libro);

}
