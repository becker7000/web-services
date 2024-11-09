package mx.com.cst.webapp.jpa;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ProducerEntityManager {

    @PersistenceContext(name="jaxBD")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager(){
        return entityManager;
    }

}
