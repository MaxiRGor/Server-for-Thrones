package harelchuk.maxim.throneserver;

import harelchuk.maxim.throneserver.Leaderboard.LeaderboardIds;
import harelchuk.maxim.throneserver.Leaderboard.LeaderboardRepository;
import harelchuk.maxim.throneserver.User.User;
import harelchuk.maxim.throneserver.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ScheduleUpdatingLeaderboard {

    private UserRepository userRepository;

    private LeaderboardRepository leaderboardRepository;

    @Autowired
    ScheduleUpdatingLeaderboard(UserRepository userRepository,
                                LeaderboardRepository leaderboardRepository) {
        this.userRepository = userRepository;
        this.leaderboardRepository = leaderboardRepository;
    }

    @Scheduled(fixedRate = 1200000)       //1200000 20 min
    public void updateLeaderboard() {

        ArrayList<User> users = userRepository
                .findUsersByCreditFalseAndEasyWinningsGreaterThanAndMediumWinningsGreaterThanAndHardWinningsGreaterThanAndMoneyGreaterThan
                        (0, 0, 0, 0);
        List<UserRating> userRatings = new ArrayList<>();

        if (users.size() > 0) {
            for (User user : users) {
                UserRating userRating = new UserRating(user.getId(), user.getMoney(),
                        user.getHardWinnings(),
                        user.getHardGames(),
                        user.getMediumWinnings(),
                        user.getMediumGames(),
                        user.getEasyWinnings(),
                        user.getEasyGames());
                userRatings.add(userRating);
            }

            Collections.sort(userRatings);

            int numberOfLeaders = 1000;
            if (numberOfLeaders > userRatings.size())
                numberOfLeaders = userRatings.size();

            leaderboardRepository.deleteAll();

            for (int i = 0; i < numberOfLeaders; i++) {
                LeaderboardIds leaderboardIds = new LeaderboardIds(userRatings.get(i).getId());
                leaderboardRepository.save(leaderboardIds);
            }
        }
    }

    public class UserRating implements Comparable<UserRating> {
        int id;
        double rating;

        UserRating(int id, long money, int hw, int hg, int mw, int mg, int ew, int eg) {
            this.id = id;
            this.rating = money * ((double) hw / (double) hg * 0.6
                    + (double) mw / (double) mg * 0.3
                    + (double) ew / (double) eg * 0.1) / 100;
        }

        double getRating() {
            return rating;
        }

        public int getId() {
            return id;
        }

        @Override
        public int compareTo(UserRating o) {
            return (int) (o.getRating() - this.getRating());
        }
    }
}

