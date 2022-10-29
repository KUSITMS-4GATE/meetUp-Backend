package meetUpBackend.gload.repository;

import meetUpBackend.gload.domain.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class roadMapRepository {
    public interface roadMapRepository extends JpaRepository<Roadmap, Long> {
        //select m from Member m where m.name = ?
        List<Roadmap> findByName(String name); //메서드 이름을 보고 ?를 채워 넣는다.(findByName)

    }
}
