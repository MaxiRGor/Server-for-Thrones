package harelchuk.maxim.throneserver.MultiGames;

import harelchuk.maxim.throneserver.Question.QuestionRepository;
import harelchuk.maxim.throneserver.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games/multi")
public class MultiGamesController {
    private UserRepository userRepository;
    private MultiGamesRepository multiGamesRepository;
    private QuestionRepository questionRepository;

    @Autowired
    MultiGamesController(UserRepository userRepository, MultiGamesRepository multiGamesRepository, QuestionRepository questionRepository) {
        this.multiGamesRepository = multiGamesRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }
}
