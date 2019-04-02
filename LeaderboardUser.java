package harelchuk.maxim.throneserver;

import javax.persistence.*;

@Entity
@Table(name = "leaderboard")
public class LeaderboardUser {

    LeaderboardUser() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    public int user_id;

    LeaderboardUser(int user_id) {
        //this.id = 0;
        this.user_id = user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
