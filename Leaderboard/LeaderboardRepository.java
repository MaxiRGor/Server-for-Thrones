package harelchuk.maxim.throneserver.Leaderboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaderboardRepository extends JpaRepository<LeaderboardIds, Integer> {

    @Query(value = "select user_id from `leaderboard` ", nativeQuery = true)
    List<Integer> selectAllId();

}
