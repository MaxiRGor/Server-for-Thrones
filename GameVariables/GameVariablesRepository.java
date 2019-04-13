package harelchuk.maxim.throneserver.GameVariables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GameVariablesRepository extends JpaRepository<GameVariables, Integer> {
    //ArrayList<GameVariables> findAll();
    ArrayList<GameVariables> findAllBySingleDifficultyRewardsNotAndSingleDifficultyCostsNot(int zero1, int zero2);

    ArrayList<GameVariables> findAllByThemeCostsNot(int zero);

    ArrayList<GameVariables> findAllByMultiRatingMinNotAndMultiRatingRewardsNot(int zero1, int zero2);

    ArrayList<GameVariables> findAllByIconsCostsNot(int zero);
}
