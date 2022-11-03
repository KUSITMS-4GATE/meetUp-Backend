package meetUpBackend.gload.repository;

import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Roadmap;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class roadMapRepository {

    private final EntityManager em;

    public void save(Roadmap roadmap) {
        em.persist(roadmap);
    }

}
