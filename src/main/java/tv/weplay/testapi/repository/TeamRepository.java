package tv.weplay.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tv.weplay.testapi.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
