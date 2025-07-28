package brick.it.back.exception;

public class InstructionNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 582237545785868420L;

	public InstructionNotFoundException(Long id) {
		super("Could not find the instruction with id " + id);
	}

	// added for unit testing
	public InstructionNotFoundException(String message) {
		super(message);
	}
}