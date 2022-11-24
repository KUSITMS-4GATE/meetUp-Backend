package meetUpBackend.groad.service;


import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.Member;
import meetUpBackend.groad.domain.MyPage;
import meetUpBackend.groad.domain.Resume;
import meetUpBackend.groad.repository.myResumeRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class myResumeService {

    private final myResumeRepository myResumeRepository;

    public List<Resume> findAll(String userId) {
        return myResumeRepository.findAll(userId);
    }

    @Transactional
    public Member getMember(String userId){
        return myResumeRepository.getMember(userId);
    }

    @Transactional
    public void join(Resume resume){
        myResumeRepository.save(resume);
    }

    @Transactional
    public Resume selectOne(String userId, Long resumeId){

        return myResumeRepository.findOne(userId, resumeId);
    }

    @Transactional
    public void updateById(Resume resume, String userId, Long resumeId) {
        myResumeRepository.update(resume, userId, resumeId);
    }

    @Transactional
    public int deleteOne(String userId, Long resumeId){

        return myResumeRepository.deleteOne(userId, resumeId);
    }

    @Transactional
    public int recommendOne(String userId){

        return myResumeRepository.recommendOne(userId);
    }

    @Transactional
    public int reportOne(String userId){

        return myResumeRepository.reportOne(userId);
    }

    @Transactional
    public int scrapOne(String userId){
        return myResumeRepository.scrapOne(userId);
    }
}