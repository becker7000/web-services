package mx.com.cst.webapp.jpa.repository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.com.cst.webapp.jpa.model.Libro;

import java.util.List;

@RequestScoped
public class LibroRepositoryImp implements LibroRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Libro> listarLibros() {
        return entityManager.createQuery("SELECT l FROM Libro l",Libro.class).getResultList();
    }

    @Override
    public Libro guardar(Libro libro) {
        entityManager.persist(libro);
        return libro;
    }
}
