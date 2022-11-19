package meetUpBackend.groad.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.MyPage;
import meetUpBackend.groad.domain.Roadmap;
import meetUpBackend.groad.domain.User;
import meetUpBackend.groad.repository.myPageRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class myPageService {

    private final myPageRepository myPageRepository;

    @Transactional
    public Roadmap getMyPage(User userId){
        return myPageRepository.getRoadMapOne(userId);
    }

    @Transactional
    public void saveMyPageInfo(MyPage myPage) {
        myPageRepository.saveMyPage(myPage);
    }

    @Transactional
    public void updateMyPageInfo(MyPage myPage, String id) {
        myPageRepository.updateMyPage(myPage,id);
    }
}
