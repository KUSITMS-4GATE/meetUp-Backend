package meetUpBackend.groad.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.MyPage;
import meetUpBackend.groad.domain.User;
import meetUpBackend.groad.repository.MyPageRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MyPageService {

    private final MyPageRepository myPageRepository;

    @Transactional
    public MyPage getMyPage(User userId){
        return myPageRepository.getMyPageOne(userId);
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
