package meetUpBackend.gload.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Review;
import meetUpBackend.gload.domain.Roadmap;
import meetUpBackend.gload.repository.roadMapRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class roadMapService {

    private final roadMapRepository roadMapRepository;

    /**
     * 로드맵 데이터 저장
     */

    public List<Roadmap> findAll() {
        return roadMapRepository.findAll();
    }

    @Transactional
    public Roadmap selectOne(Long actSemesterId){

        return roadMapRepository.findOne(actSemesterId);
    }

}
