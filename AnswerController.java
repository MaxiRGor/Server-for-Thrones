package harelchuk.maxim.throneserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    Answer getAnswer(@PathVariable int id_answer) {
        return answerRepository.findById(id_answer)
                .orElseThrow(() -> new AnswerNotFoundException(id_answer));
    }


    @PutMapping("/{id_answer}/{user_answer}")
    public void updateAnswer(@PathVariable int id_answer,
                             @PathVariable int user_answer) {
        answerRepository.findById(id_answer)
                .map(answer -> {
                    if (user_answer == 1) answer.setAnswer_one(answer.getAnswer_one() + 1);
                    if (user_answer == 2) answer.setAnswer_two(answer.getAnswer_two() + 1);
                    if (user_answer == 3) answer.setAnswer_three(answer.getAnswer_three() + 1);
                    if (user_answer == 4) answer.setAnswer_four(answer.getAnswer_four() + 1);
                    return answerRepository.save(answer);
                })
                .orElseThrow(() -> new AnswerNotFoundException(id_answer));
    }
}
