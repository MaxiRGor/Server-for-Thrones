package harelchuk.maxim.throneserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleUpdateDB {

    private UserRepository userRepository;
    private LeaderboardRepository leaderboardRepository;

    @Autowired
    ScheduleUpdateDB(UserRepository userRepository,
                     LeaderboardRepository leaderboardRepository) {
        this.userRepository = userRepository;
        this.leaderboardRepository = leaderboardRepository;
    }

    @Scheduled(fixedRate = 600000)       //10 min
    public void updateLeaderboard() {

        int leadersNumber = 10;

        List<Integer> sortedIds = userRepository.getSortedIds();

        for (int i = 0; i < leadersNumber; i++) {
            LeaderboardUser leaderboardUser = leaderboardRepository.getLeaderboardUserById(i + 1);
            leaderboardUser.setUser_id(sortedIds.get(i));
            leaderboardRepository.save(leaderboardUser);
        }

    }

}

