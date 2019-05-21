package esir.tp.doodle.jpa.exception;

public class PollNotFoundException extends RuntimeException {
    public PollNotFoundException(Long id) {
        super("Could not find poll " + id);
    }
}
