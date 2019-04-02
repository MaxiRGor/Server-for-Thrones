package harelchuk.maxim.throneserver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_answer;

    private int id_question;

    private int right_answer;

    private int answer_one;

    private int answer_two;

    private int answer_three;

    private int answer_four;

    public Integer getId_answer() {
        return id_answer;
    }

    public int getId_question() {
        return id_question;
    }

    public int getRight_answer() {
        return right_answer;
    }

    public int getAnswer_one() {
        return answer_one;
    }

    public int getAnswer_two() {
        return answer_two;
    }

    public int getAnswer_three() {
        return answer_three;
    }

    public int getAnswer_four() {
        return answer_four;
    }

    public void setId_answer(Integer id_answer) {
        this.id_answer = id_answer;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public void setRight_answer(int right_answer) {
        this.right_answer = right_answer;
    }

    public void setAnswer_one(int answer_one) {
        this.answer_one = answer_one;
    }

    public void setAnswer_two(int answer_two) {
        this.answer_two = answer_two;
    }

    public void setAnswer_three(int answer_three) {
        this.answer_three = answer_three;
    }

    public void setAnswer_four(int answer_four) {
        this.answer_four = answer_four;
    }
}
