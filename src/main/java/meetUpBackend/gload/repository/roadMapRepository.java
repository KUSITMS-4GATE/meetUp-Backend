package meetUpBackend.gload.repository;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    public ActSemester getActSemesterOne(Long id) {
        return em.find(ActSemester.class, id);
    }

    public Roadmap getRoadMapOne(Long id) {
        return em.find(Roadmap.class, id);
    }

    public void updateRoadMap(Roadmap roadmap, Long mapId) {
        Query query = em.createQuery(
        "update Roadmap r set r.category = :category, r.content = :content , r.title = :title ," +
                "r.state = :state, r.grade = :grade, r.roadmapStrDate = :roadmapStrDate, r.roadmapEndDate = :roadmapEndDate" +
                "where r.mapId = :mapId");
        query.setParameter("category", roadmap.getCategory());
        query.setParameter("content", roadmap.getContent());
        query.setParameter("title", roadmap.getTitle());
        query.setParameter("state", roadmap.getState());
        query.setParameter("grade", roadmap.getGrade());
        query.setParameter("roadmapStrDate", roadmap.getRoadmapStrDate());
        query.setParameter("roadmapEndDate", roadmap.getRoadmapEndDate());
        query.setParameter("mapId", mapId);
        int rowUpdated = query.executeUpdate();
        System.out.println("rowUpdated" + rowUpdated);
    }

    public int deleteRoadMap(Long id) {
        return em.createQuery("update Roadmap r set r.actDelete = 'YES' , r.mapDelete = 'YES' where r.id = :id")
                .setParameter("id", id)
                .executeUpdate();
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
