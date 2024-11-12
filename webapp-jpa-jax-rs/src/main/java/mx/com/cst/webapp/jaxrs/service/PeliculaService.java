package mx.com.cst.webapp.jaxrs.service;

import jakarta.ejb.Local;
import mx.com.cst.webapp.jaxrs.model.Libro;
import mx.com.cst.webapp.jaxrs.model.Pelicula;

import java.util.List;
import java.util.Optional;

@Local
public interface PeliculaService {

    List<Pelicula> listar();
    Pelicula guardar(Pelicula pelicula);
    Optional<Pelicula> porId(int id);
    void eliminar(int id);

}
