package harelchuk.maxim.throneserver;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeaderboardRepository extends CrudRepository<LeaderboardUser, Integer> {

    @Query("from LeaderboardUser where id = ?1")
    LeaderboardUser getLeaderboardUserById(int id);

    @Query("select user_id from LeaderboardUser ")
    List<Integer> getUsersId();

}
