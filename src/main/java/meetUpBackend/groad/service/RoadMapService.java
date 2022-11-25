package meetUpBackend.groad.service;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.common.exception.CustomException;
import meetUpBackend.groad.common.exception.ErrorCode;
import meetUpBackend.groad.domain.ActSemester;
import meetUpBackend.groad.domain.Roadmap;
import meetUpBackend.groad.repository.RoadMapRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class RoadMapService {

    private final RoadMapRepository roadMapRepository;

    /**
     * ActSemester data save
     */
    @Transactional
    public void saveActSemester(ActSemester actSemester){
        roadMapRepository.saveActSemester(actSemester);
    }

    /**
     * 로드맵 데이터 저장
     */

    @Transactional
    public void saveRoadMap(Roadmap roadMap) {
        try {
            roadMapRepository.saveRoadMap(roadMap);
            throw new CustomException(ErrorCode.NVALID_PARAMETER);
        }catch (Exception e ){
            e.printStackTrace();
        }

    }
    public List<Roadmap> findAll() {
        return roadMapRepository.findAll();
    }


    @Transactional
    public ActSemester getActSemester(Long actSemesterId){

        return roadMapRepository.getActSemesterOne(actSemesterId);
    }

    @Transactional
    public Roadmap getRoadMap(Long roadMapId){
        return roadMapRepository.getRoadMapOne(roadMapId);
    }
    @Transactional
    public void updateRoadMap(Roadmap roadmap, Long mapId) {
        roadMapRepository.updateRoadMap(roadmap, mapId);
    }

    public int deleteRoadMap(Long roadMapId) {
        return roadMapRepository.deleteRoadMap(roadMapId);
    }

    @Transactional
    public void updateActSemester(ActSemester actSemester, Long actSemesterId) {
        roadMapRepository.updateActSemester(actSemester, actSemesterId);
    }

//    public int deleteActSemester(Long actSemesterId) {
//        return roadMapRepository.deleteActSemester(actSemesterId);
//    }
}
