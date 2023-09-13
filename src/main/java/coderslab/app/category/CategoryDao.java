package coderslab.app.category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CategoryDao {
    @PersistenceContext
    EntityManager em;

    public void save (Category entity) {
        em.persist(entity);
    }

    public void delete (Category entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public void edit (Category entity) {
        em.merge(entity);
    }
}
