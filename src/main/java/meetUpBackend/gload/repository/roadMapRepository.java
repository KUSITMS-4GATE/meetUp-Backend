package meetUpBackend.gload.repository;

import meetUpBackend.gload.domain.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roadMapRepository extends JpaRepository<Roadmap, Long> {
}
