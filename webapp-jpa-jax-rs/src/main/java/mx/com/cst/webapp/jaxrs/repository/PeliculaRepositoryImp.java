package mx.com.cst.webapp.jaxrs.repository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import mx.com.cst.webapp.jaxrs.model.Pelicula;

import java.util.List;

@RequestScoped
public class PeliculaRepositoryImp implements PeliculaRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public List listar() {
        return entityManager
                .createQuery("SELECT p FROM Pelicula p")
                .getResultList();
    }

    @Override
    public Pelicula guardar(Pelicula pelicula) {
        if(pelicula.getId()>0){
            entityManager.merge(pelicula);
        }else {
            entityManager.persist(pelicula);
        }
        return pelicula;
    }

    @Override
    public Pelicula porId(int id) {
        return entityManager.find(Pelicula.class,id);
    }

    @Override
    public void eliminar(int id) {
        Pelicula pelicula = porId(id);
        entityManager.remove(pelicula);
    }
}
