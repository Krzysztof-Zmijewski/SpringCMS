package coderslab.app.article;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager em;

    public void save (Article entity) {
        em.persist(entity);
    }

    public void delete (Article entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public void edit (Article entity) {
        em.merge(entity);
    }
}
