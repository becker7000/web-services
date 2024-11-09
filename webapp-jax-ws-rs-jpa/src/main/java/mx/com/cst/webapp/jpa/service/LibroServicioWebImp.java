package mx.com.cst.webapp.jpa.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import mx.com.cst.webapp.jpa.model.Libro;
import mx.com.cst.webapp.jpa.repository.LibroRepository;

import java.util.List;

@Stateless
@WebService(endpointInterface = "mx.com.cst.webapp.jpa.service.LibroServicioWeb")
public class LibroServicioWebImp implements LibroServicioWeb {

    @Inject
    private LibroRepository libroRepository;

    @WebMethod
    @Override
    public List<Libro> listar() {
        return libroRepository.listarLibros();
    }

    @WebMethod
    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.guardar(libro);
    }
}
