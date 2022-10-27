package meetUpBackend.gload.service;

import lombok.RequiredArgsConstructor;
import meetUpBackend.gload.domain.Roadmap;
import meetUpBackend.gload.repository.roadMapRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class roadMapService {

    private final roadMapRepository roadMapRepository;

    /**
     * 로드맵 데이터 저장
     */
    @Transactional
    public Long join(Roadmap roadMap) {
//        validateDuplicateMember(roadMap); //중복 회원 검증
        roadMapRepository.save(roadMap);
        return roadMap.getId();
    }

//    private void validateDuplicateMember(Roadmap roadmap) {
//        List<Roadmap> findData = roadMapRepository.findByName(member.getName());
//        if(!findMembers.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }
//    }

//    //회원 전체 조회
//    public List<Member> findMembers() {
//        return memberRepository.findAll();
//    }
//
//    public Member findOne(Long memberId) {
//        return memberRepository.findById(memberId).get();
//    }
//
//    @Transactional
//    public void update(Long id, String name) {
//        Member member = memberRepository.findById(id).get();
//        member.setName(name);
//    }

}
