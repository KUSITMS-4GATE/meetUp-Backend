package meetUpBackend.groad.repository;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.Member;
import meetUpBackend.groad.domain.Resume;
import meetUpBackend.groad.domain.ResumeDelete;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class myResumeRepository {
    private final EntityManager em;

    public Member getMember(String userId) {
        return em.createQuery("select m from Member m where m.userId = :userId", Member.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    public void save(Resume resume) {
        em.persist(resume);
    }

    public List<Resume> findAll(String userId) {
        return em.createQuery("select r from Resume r where r.member.userId = :userId", Resume.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public Resume findOne(String userId, Long resumeId) {
        return em.createQuery("select r from Resume r where r.member.userId = :userId and r.resumeId = :resumeId", Resume.class)
                .setParameter("userId", userId)
                .setParameter("resumeId", resumeId)
                .getSingleResult();
    }


    public int deleteOne(String userId, Long resumeId) {
        return em.createQuery("update Resume r set r.resumeDelete = 'YES' where r.member.userId = :userId and r.resumeId = :resumeId")
                .setParameter("userId", userId)
                .setParameter("resumeId", resumeId)
                .executeUpdate();
    }

    public int recommendOne(String userId) {
        return em.createQuery("update Event e set e.like = e.like + 1 where e.userId = :userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }

    public int reportOne(String userId) {
        return em.createQuery("update Report r set r.count = r.count + 1 where r.userId = :userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }

    public int scrapOne(String userId) {
        return em.createQuery("update Event e set e.scrap = e.scrap + 1 where e.userId = :userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }


    public void update(Resume resume, String userId, Long resumeId) {
         em.createQuery("update Resume r set r.category = :category, r.content = :content , r.title = :title, r.resumeDelete = :resumeDelete, r.updDate = :updDate where r.resumeId = :resumeId and r.member.userId = :userId")
                .setParameter("category", resume.getCategory())
                .setParameter("content", resume.getContent())
                .setParameter("title", resume.getTitle())
                .setParameter("userId", userId)
                .setParameter("resumeDelete", ResumeDelete.valueOf("NO"))
                .setParameter("updDate", LocalDateTime.now())
                .setParameter("resumeId", resumeId)
                .executeUpdate();

    }
}