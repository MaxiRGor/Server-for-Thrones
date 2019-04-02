package harelchuk.maxim.throneserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping(path = "/ru/level/{level}/{in_book}/{in_serial}")
    public @ResponseBody
    List<Question> getLevelQuestions(@PathVariable("level") int level,
                                     @PathVariable("in_book") boolean in_book,
                                     @PathVariable("in_serial") boolean in_serial) {
        if (in_book && in_serial) {
            return getSevenQuestions(questionRepository.findByLevel(level));
        } else {
            if (in_book) {
                return getSevenQuestions(questionRepository.findByLevelBook(level, true));
            } else {
                return getSevenQuestions(questionRepository.findByLevelSerial(level, true));
            }
        }
    }

    @GetMapping(path = "/ru/category/{category}/{in_book}/{in_serial}")
    public @ResponseBody
    List<Question> getCategoryQuestions(@PathVariable("category") int category,
                                        @PathVariable("in_book") boolean in_book,
                                        @PathVariable("in_serial") boolean in_serial) {
        if (in_book && in_serial) {
            return getSevenQuestions(questionRepository.findByCategory(category));
        } else {
            if (in_book) {
                return getSevenQuestions(questionRepository.findByCategoryBook(category, true));
            } else {
                return getSevenQuestions(questionRepository.findByCategorySerial(category, true));
            }
        }
    }

    private List<Question> getSevenQuestions(ArrayList<Integer> selectedQuestionsID) {
        int[] ids = new int[7];
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            int randomIndex = rand.nextInt(selectedQuestionsID.size());
            ids[i] = selectedQuestionsID.get(randomIndex);
            if (selectedQuestionsID.size() > 1) {
                selectedQuestionsID.remove(randomIndex);
            }
        }
        return questionRepository.findSevenByID(ids[0], ids[1], ids[2], ids[3], ids[4], ids[5], ids[6]);
    }
}
