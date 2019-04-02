package harelchuk.maxim.throneserver;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_question;

    private String question_text;

    private String answer_one;

    private String answer_two;

    private String answer_three;

    private String answer_four;

    private int right_answer;

    private int level;

    private boolean in_book;

    private boolean in_serial;

    private int category;


    public Integer getId_question() {
        return id_question;
    }


    public String getQuestion_text() {
        return question_text;
    }


    public String getAnswer_one() {
        return answer_one;
    }

    public String getAnswer_two() {
        return answer_two;
    }

    public String getAnswer_three() {
        return answer_three;
    }

    public String getAnswer_four() {
        return answer_four;
    }

    public int getRight_answer() {
        return right_answer;
    }

    public int getLevel() {
        return level;
    }

    public boolean getIn_serial() {
        return in_serial;
    }


    public boolean getIn_book() {
        return in_book;
    }

    public int getCategory() {
        return category;
    }
}
