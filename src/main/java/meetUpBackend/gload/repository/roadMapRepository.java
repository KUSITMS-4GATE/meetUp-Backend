package meetUpBackend.gload.repository;

import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Review;
import meetUpBackend.gload.domain.Roadmap;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class roadMapRepository {

    private final EntityManager em;

    public void save(Roadmap roadmap) {
        em.persist(roadmap);
    }

    public List<Roadmap> findAll() {
        return em.createQuery("select r from Roadmap r", Roadmap.class)
                .getResultList();
    }

    public Roadmap findOne(Long id) {
        return em.find(Roadmap.class, id);
    }

}
