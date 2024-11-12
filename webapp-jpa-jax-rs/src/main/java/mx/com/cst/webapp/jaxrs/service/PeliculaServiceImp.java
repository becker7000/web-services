package mx.com.cst.webapp.jaxrs.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import mx.com.cst.webapp.jaxrs.model.Pelicula;
import mx.com.cst.webapp.jaxrs.repository.PeliculaRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class PeliculaServiceImp implements PeliculaService{

    @Inject
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> listar() {
        return peliculaRepository.listar();
    }

    @Override
    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepository.guardar(pelicula);
    }

    @Override
    public Optional<Pelicula> porId(int id) {
        return Optional.ofNullable(peliculaRepository.porId(id));
    }

    @Override
    public void eliminar(int id) {
        peliculaRepository.eliminar(id);
    }
}
