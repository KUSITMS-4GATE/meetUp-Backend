package meetUpBackend.groad.repository;

import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.User;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class userRepository {
	private final EntityManager em;
	public User getUserId(String userId) {
		return em.find(User.class, userId);
	}

	public void regUser(User user) {
		em.persist(user);
	}
}
