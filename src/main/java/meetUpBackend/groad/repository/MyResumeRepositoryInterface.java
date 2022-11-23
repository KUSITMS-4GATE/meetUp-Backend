package meetUpBackend.groad.repository;

import meetUpBackend.groad.domain.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyResumeRepositoryInterface extends JpaRepository<Resume, Long> {
    List<Resume> findByTitleContaining(String searchWord);
    List<Resume> findByContentContaining(String searchWord);
}