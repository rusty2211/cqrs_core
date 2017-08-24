package cqrs.core.exception;

/**
 * This class is responsible to handle class initiate exception
 * 
 * @author raghav
 *
 */
public class InitiateException extends Exception {

	private static final long serialVersionUID = 1968214389873411384L;

	public InitiateException() {
	}

	public InitiateException(String message) {
		super(message);
	}

	public InitiateException(Throwable throwable) {
		super(throwable);
	}
}
