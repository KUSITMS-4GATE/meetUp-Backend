package meetUpBackend.groad.repository;

import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.ActSemester;
import meetUpBackend.groad.domain.Roadmap;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
@RequiredArgsConstructor
public class myPageRepository {

    private final EntityManager em;

    public Roadmap getRoadMapOne(Long id) {
        return em.find(Roadmap.class, id);
    }

    public void saveActSemester(ActSemester actSemester) {
        em.persist(actSemester);
    }

    public void updateActSemester(ActSemester actSemester, Long id) {
        Query query = em.createQuery(
                "update ActSemester a set a.year = :year, a.semester = :semester " +
                        "where a.id = :id");
        query.setParameter("year", actSemester.getYear());
        query.setParameter("semester", actSemester.getSemester());
        int rowUpdated = query.executeUpdate();
        System.out.println("rowUpdated" + rowUpdated);
    }

}
