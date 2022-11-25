package meetUpBackend.groad.service;

import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.MyPage;
import meetUpBackend.groad.repository.ResumeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ResumeService {
    private final ResumeRepository resumeRepository;

    @Transactional
    public List<MyPage> findAll() {
        return resumeRepository.findAll();
    }

    @Transactional
    public MyPage selectOne(String userId) {
        return resumeRepository.findOne(userId);
    }

    @Transactional
    public List<MyPage> findSchool(String schoolName) {
        return resumeRepository.findSchool(schoolName);
    }

    @Transactional
    public List<MyPage> findMajor(String majorType) {
        return resumeRepository.findMajor(majorType);
    }

    @Transactional
    public List<MyPage> findGrade(Integer gradeNum) {
        return resumeRepository.findGrade(gradeNum);
    }

    @Transactional
    public List<MyPage> findCareer(String careerType) {
        return resumeRepository.findCareer(careerType);
    }

}