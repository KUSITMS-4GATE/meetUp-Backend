package meetUpBackend.gload.service;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.ActSemester;
import meetUpBackend.gload.domain.Roadmap;
import meetUpBackend.gload.repository.roadMapRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class roadMapService {

    private final roadMapRepository roadMapRepository;

    /**
     * ActSemester data save
     */
    @Transactional
    public void saveActSemester(ActSemester actSemester) {
        roadMapRepository.saveActSemester(actSemester);
    }

    /**
     * 로드맵 데이터 저장
     */

    @Transactional
    public void saveRoadMap(Roadmap roadMap) {
        roadMapRepository.saveRoadMap(roadMap);
    }
    public List<Roadmap> findAll() {
        return roadMapRepository.findAll();
    }


    @Transactional
    public Roadmap selectOne(Long actSemesterId){

        return roadMapRepository.findOne(actSemesterId);
    }

}
