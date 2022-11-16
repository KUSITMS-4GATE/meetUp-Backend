package meetUpBackend.groad.service;

import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.ActSemester;
import meetUpBackend.groad.domain.Roadmap;
import meetUpBackend.groad.repository.myPageRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class myPageService {

    private final myPageRepository myPageRepository;

    @Transactional
    public Roadmap getMyPage(Long roadMapId){
        return myPageRepository.getRoadMapOne(roadMapId);
    }

    @Transactional
    public void saveActSemester(ActSemester actSemester){
        myPageRepository.saveActSemester(actSemester);
    }

    @Transactional
    public void updateActSemester(ActSemester actSemester, Long actSemesterId) {
        myPageRepository.updateActSemester(actSemester, actSemesterId);
    }

}
