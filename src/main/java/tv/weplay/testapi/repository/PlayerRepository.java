package tv.weplay.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tv.weplay.testapi.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
