package harelchuk.maxim.throneserver.MultiGames;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultiGamesRepository extends JpaRepository<MultiGames, Integer> {
}
