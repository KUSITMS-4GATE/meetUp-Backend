package meetUpBackend.groad.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.Member;
import meetUpBackend.groad.domain.MyPage;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MyPageRepository {

    private final EntityManager em;

    public MyPage getMyPageOne(Member id) {
        return em.createQuery("select m from MyPage m where m.userId.userId = :userId", MyPage.class)
                .setParameter("userId", id.getUserId())
                .getSingleResult();
    }

    public void saveMyPage(MyPage myPage) {
        em.persist(myPage);
    }

    public void updateMyPage(MyPage myPage, String id) {
        Query query = em.createQuery(
                "update MyPage r set r.college = :college, r.major = :major," +
                        "r.enterYear = :enterYear, r.grade = :grade, r.career = :career," +
                        "r.company = :company, r.selfIntroduce = :selfIntroduce, r.updDate = :updDate " +
                        "where r.userId.userId = :userId");
        query.setParameter("college", myPage.getCollege());
        query.setParameter("major", myPage.getMajor());
        query.setParameter("enterYear", myPage.getEnterYear());
        query.setParameter("grade", myPage.getGrade());
        query.setParameter("career", myPage.getCareer());
        query.setParameter("company", myPage.getCompany());
        query.setParameter("selfIntroduce", myPage.getSelfIntroduce());
        query.setParameter("updDate", myPage.getUpdDate());
        query.setParameter("userId", id);
        int rowUpdated = query.executeUpdate();
        System.out.println("rowUpdated" + rowUpdated);
    }
}
