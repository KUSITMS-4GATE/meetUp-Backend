package meetUpBackend.gload.repository;

import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.ActSemester;
import meetUpBackend.gload.domain.Roadmap;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class roadMapRepository {

    private final EntityManager em;

    public void saveActSemester(ActSemester actSemester) {
        em.persist(actSemester);
    }

    public void saveRoadMap(Roadmap roadmap) {
        em.persist(roadmap);
    }

    public List<Roadmap> findAll() {
        return em.createQuery("select r from Roadmap r", Roadmap.class)
                .getResultList();
    }

    public ActSemester findOne(Long id) {
        return em.find(ActSemester.class, id);
    }
}
