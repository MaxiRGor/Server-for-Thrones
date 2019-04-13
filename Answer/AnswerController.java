package harelchuk.maxim.throneserver.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @GetMapping("/{id_answer}")
    public @ResponseBody
    Answer getAnswers(@PathVariable int id_answer) {
        return answerRepository.findById(id_answer)
                .orElseThrow(() -> new AnswerNotFoundException(id_answer));
    }

    @PutMapping("update/seven/{id_answers}/{user_answers}")
    public void updateAnswer(@PathVariable int[] id_answers,
                             @PathVariable int[] user_answers) {
        List<Answer> answers = answerRepository.findAnswersByIdAnswerIn(id_answers);
        for (int id_answer : id_answers) {
            switch (user_answers[id_answer]) {
                case 1:
                    answers.get(id_answer).incrementOne();
                    break;
                case 2:
                    answers.get(id_answer).incrementTwo();
                    break;
                case 3:
                    answers.get(id_answer).incrementThree();
                    break;
                case 4:
                    answers.get(id_answer).incrementFour();
                    break;
            }
        }
        answerRepository.saveAll(answers);
    }
}
