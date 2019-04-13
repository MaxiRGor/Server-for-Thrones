package harelchuk.maxim.throneserver.Question;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @Column(name = "id_question")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idQuestion;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "answer_one")
    private String answerOne;

    @Column(name = "answer_two")
    private String answerTwo;

    @Column(name = "answer_three")
    private String answerThree;

    @Column(name = "answer_four")
    private String answerFour;

    @Column(name = "right_answer")
    private int rightAnswer;

    @Column(name = "level")
    private int level;

    @Column(name = "difficulty")
    private int difficulty;

    @Column(name = "in_book")
    private boolean inBook;

    @Column(name = "in_serial")
    private boolean inSerial;

    @Column(name = "category")
    private int category;


    public Integer getIdQuestion() {
        return idQuestion;
    }


    public String getQuestionText() {
        return questionText;
    }


    public String getAnswerOne() {
        return answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public String getAnswerFour() {
        return answerFour;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public int getLevel() {
        return level;
    }

    public boolean getInSerial() {
        return inSerial;
    }


    public boolean getInBook() {
        return inBook;
    }

    public int getCategory() {
        return category;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
