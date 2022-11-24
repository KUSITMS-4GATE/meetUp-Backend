package meetUpBackend.groad.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.Member;
import org.springframework.stereotype.Service;
import meetUpBackend.groad.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	@Transactional
	public Member getUserId(String userId) {
		return userRepository.getUserId(userId);
	}

	@Transactional
	public void regUser(Member user) {
		userRepository.regUser(user);
	}
}
