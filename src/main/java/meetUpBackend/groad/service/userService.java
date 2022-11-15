package meetUpBackend.groad.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.User;
import org.springframework.stereotype.Service;
import meetUpBackend.groad.repository.userRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class userService {
	private final userRepository userRepository;

	@Transactional
	public User getUserId(String userId) {
		return userRepository.getUserId(userId);
	}

	@Transactional
	public void regUser(User user) {
		userRepository.regUser(user);
	}
}
