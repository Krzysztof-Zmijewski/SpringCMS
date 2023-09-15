package coderslab.app.article;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Article> findAll() {
        TypedQuery<Article> query = em.createQuery("SELECT a from Article a", Article.class);
        return query.getResultList();
    }

    public List<Article> findLatestFive() {
        TypedQuery<Article> query = em.createQuery("SELECT a FROM Article a ORDER BY a.id desc", Article.class);
        query.setMaxResults(5);
        return query.getResultList();
    }
}
