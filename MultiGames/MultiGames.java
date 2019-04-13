package harelchuk.maxim.throneserver.MultiGames;

import javax.persistence.*;


@Entity
@Table(name = "multi_games")
public class MultiGames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "game_range")
    private int gameRange;

    @Column(name = "create_time")
    private long createTime;

    @Column(name = "user_first_id")
    private int userFirstId;

    @Column(name = "user_fisrt_status")
    private int userFirstStatus;

    @Column(name = "user_first_count")
    private int userFirstCount;

    @Column(name = "user_second_id")
    private int userSecondId;

    @Column(name = "user_second_status")
    private int userSecondStatus;

    @Column(name = "user_second_count")
    private long userSecondCount;


}

