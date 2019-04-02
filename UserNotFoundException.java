package harelchuk.maxim.throneserver;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(int id) {
        super("Could not find user " + id);
    }
}