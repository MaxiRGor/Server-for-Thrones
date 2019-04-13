package harelchuk.maxim.throneserver.GameVariables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/variables")       //->variables
public class GameVariablesController {
    private GameVariablesRepository gameVariablesRepository;

    @Autowired
    GameVariablesController(GameVariablesRepository gameVariablesRepository) {
        this.gameVariablesRepository = gameVariablesRepository;
    }

    //////////////////////////////////////////////
    @GetMapping(path = "/get/single")
    public @ResponseBody
    int[][] getSingleValues() {
        ArrayList<GameVariables> variables = gameVariablesRepository
                .findAllBySingleDifficultyRewardsNotAndSingleDifficultyCostsNot(0, 0);
        int[][] values = new int[2][variables.size()];
        for (int i = 0; i < variables.size(); i++) {
            values[0][i] = variables.get(i).getSingleDifficultyCosts();
            values[1][i] = variables.get(i).getSingleDifficultyRewards();
        }
        return values;
    }

    //////////////////////////////////////////////
    @GetMapping(path = "/get/theme")
    public @ResponseBody
    int[] getThemeCosts() {
        ArrayList<GameVariables> variables = gameVariablesRepository
                .findAllByThemeCostsNot(0);
        int[] values = new int[variables.size()];
        for (int i = 0; i < variables.size(); i++) {
            values[i] = variables.get(i).getThemeCosts();
        }
        return values;
    }

    //////////////////////////////////////////////
    @GetMapping(path = "/get/multi")
    public @ResponseBody
    int[][] getMultiValues() {
        ArrayList<GameVariables> variables = gameVariablesRepository
                .findAllByMultiRatingMinNotAndMultiRatingRewardsNot(0, 0);
        int[][] values = new int[2][variables.size()];
        for (int i = 0; i < variables.size(); i++) {
            values[0][i] = variables.get(i).getMultiRatingMin();
            values[1][i] = variables.get(i).getMultiRatingRewards();
        }
        return values;
    }

    //////////////////////////////////////////////
    @GetMapping(path = "/get/icons")
    public @ResponseBody
    int[] getIconsCosts() {
        ArrayList<GameVariables> variables = gameVariablesRepository
                .findAllByIconsCostsNot(0);
        int[] values = new int[variables.size()];
        for (int i = 0; i < variables.size(); i++) {
            values[i] = variables.get(i).getIconsCosts();
        }
        return values;
    }
}
