package coderslab.app.author;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager em;

    public void save (Author entity) {
        em.persist(entity);
    }

    public void delete (Author entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public void edit (Author entity) {
        em.merge(entity);
    }
}
