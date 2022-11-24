package meetUpBackend.groad.repository;

import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import meetUpBackend.groad.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {
	private final EntityManager em;
	public Member getUserId(String userId) {
		return em.find(Member.class, userId);
	}

	public void regUser(Member user) {
		em.persist(user);
	}
}
