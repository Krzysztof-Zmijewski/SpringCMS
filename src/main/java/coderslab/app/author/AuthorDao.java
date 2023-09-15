package coderslab.app.author;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Author> findAll () {
        TypedQuery<Author> query = em.createQuery("SELECT a FROM Author a", Author.class);
        return query.getResultList();
    }
}
