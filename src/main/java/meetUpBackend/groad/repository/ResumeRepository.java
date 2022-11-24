package meetUpBackend.groad.repository;

import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.MyPage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResumeRepository {
    private final EntityManager em;

    public MyPage findOne(String userId) {
        return em.createQuery("select m from MyPage m where m.userId.userId = :userId", MyPage.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    public List<MyPage> findAll() {
        return em.createQuery("select m from MyPage m", MyPage.class)
                .getResultList();
    }

    public List<MyPage> findSchool(String schoolName) {
        return em.createQuery("select m from MyPage m where m.college = :schoolName", MyPage.class)
                .setParameter(("schoolName"), schoolName )
                .getResultList();
    }

    public List<MyPage> findMajor(String majorType) {
        return em.createQuery("select m from MyPage m where m.major = :majorType", MyPage.class)
                .setParameter(("majorType"), majorType )
                .getResultList();
    }

    public List<MyPage> findGrade(Integer gradeNum) {
        return em.createQuery("select m from MyPage m where m.grade = :gradeNum", MyPage.class)
                .setParameter(("gradeNum"), gradeNum )
                .getResultList();
    }

    public List<MyPage> findCareer(String careerType) {
        return em.createQuery("select m from MyPage m where m.career = :careerType", MyPage.class)
                .setParameter(("careerType"), careerType )
                .getResultList();
    }
}