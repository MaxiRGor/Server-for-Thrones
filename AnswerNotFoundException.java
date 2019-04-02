package harelchuk.maxim.throneserver;

public class AnswerNotFoundException extends RuntimeException {
    AnswerNotFoundException(int id) {
        super("Could not find answer " + id);
    }
}
