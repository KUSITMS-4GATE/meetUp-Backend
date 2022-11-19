package meetUpBackend.groad.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.MyPage;
import meetUpBackend.groad.domain.Roadmap;
import meetUpBackend.groad.domain.User;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class myPageRepository {

    private final EntityManager em;

    public Roadmap getRoadMapOne(User id) {
        return em.find(Roadmap.class, id);
    }

    public void saveMyPage(MyPage myPage) {
        em.persist(myPage);
    }

    public void updateMyPage(MyPage myPage, String id) {
        Query query = em.createQuery(
                "update MyPage r set r.college = :college, r.major = :major," +
                        "r.enterYear = :enterYear, r.grade = :grade, r.career = :career," +
                        "r.company = :company, r.selfIntroduce = :selfIntroduce " +
                        "where r.myPageId = :myPageId");
        query.setParameter("college", myPage.getCollege());
        query.setParameter("major", myPage.getMajor());
        query.setParameter("enterYear", myPage.getEnterYear());
        query.setParameter("grade", myPage.getGrade());
        query.setParameter("career", myPage.getCareer());
        query.setParameter("company", myPage.getCompany());
        query.setParameter("selfIntroduce", myPage.getSelfIntroduce());
        query.setParameter("myPageId", myPage.getMyPageId());
        int rowUpdated = query.executeUpdate();
        System.out.println("rowUpdated" + rowUpdated);
    }
}
