package mx.com.cst.webapp.jaxrs.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import mx.com.cst.webapp.jaxrs.model.Libro;
import mx.com.cst.webapp.jaxrs.repository.LibroRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class LibroServiceImp implements LibroService{

    @Inject
    private LibroRepository libroRepository;

    @Override
    public List<Libro> listar() {
        return libroRepository.listar();
    }

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.guardar(libro);
    }

    @Override
    public Optional<Libro> porId(int id) {
        return Optional.ofNullable(libroRepository.porId(id));
    }

    @Override
    public void eliminar(int id) {
        libroRepository.eliminar(id);
    }

}
