package cqrs.demo;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 1968214389873411384L;

	public ValidationException() {
	}

	public ValidationException(String message) {
		super(message);
	}

}
