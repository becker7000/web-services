package mx.com.cst.webapp.jaxrs.repository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import mx.com.cst.webapp.jaxrs.model.Libro;

import java.util.List;

@RequestScoped
public class LibroRepositoryImp implements LibroRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Libro> listar() {
        return entityManager.createQuery("SELECT l FROM Libro l",Libro.class).getResultList();
    }

    @Override
    public Libro guardar(Libro libro) {
        if(libro.getId()>0){
            entityManager.merge(libro); // Modifica un libro ya existente
        }else{
            entityManager.persist(libro); // Crea el libro desde cero
        }
        return libro;
    }

    @Override
    public Libro porId(int id) {
        return entityManager.find(Libro.class,id);
    }

    @Override
    public void eliminar(int id) {
        Libro libro = porId(id);
        entityManager.remove(libro);
    }
}
