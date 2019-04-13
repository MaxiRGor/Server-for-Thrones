package harelchuk.maxim.throneserver.Leaderboard;

import javax.persistence.*;

@Entity
@Table(name = "leaderboard")
public class LeaderboardIds {

    public LeaderboardIds() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "user_id")
    public int userId;

    public LeaderboardIds(int userId) {
        this.userId = userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
