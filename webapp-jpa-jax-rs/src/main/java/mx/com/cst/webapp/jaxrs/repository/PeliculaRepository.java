package mx.com.cst.webapp.jaxrs.repository;

import mx.com.cst.webapp.jaxrs.model.Libro;
import mx.com.cst.webapp.jaxrs.model.Pelicula;

import java.util.List;

public interface PeliculaRepository {

    List<Pelicula> listar();
    Pelicula guardar(Pelicula pelicula);
    Pelicula porId(int id);
    void eliminar(int id);

}
