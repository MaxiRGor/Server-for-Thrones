package harelchuk.maxim.throneserver.GameVariables;

import javax.persistence.*;

@Entity
@Table(name = "game_variables")
public class GameVariables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "single_difficulty_costs")
    private int singleDifficultyCosts;

    @Column(name = "multy_rating_rewards")
    private int multiRatingRewards;

    @Column(name = "multy_rating_min")
    private int multiRatingMin;

    @Column(name = "single_difficulty_rewards")
    private int singleDifficultyRewards;

    @Column(name = "theme_costs")
    private int themeCosts;

    @Column(name = "icons_costs")
    private int iconsCosts;

    public Integer getId() {
        return id;
    }

    public int getSingleDifficultyCosts() {
        return singleDifficultyCosts;
    }

    public int getMultiRatingRewards() {
        return multiRatingRewards;
    }

    public int getMultiRatingMin() {
        return multiRatingMin;
    }

    public int getSingleDifficultyRewards() {
        return singleDifficultyRewards;
    }

    public int getThemeCosts() {
        return themeCosts;
    }

    public int getIconsCosts() {
        return iconsCosts;
    }
}
