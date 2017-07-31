package cqrs.demo;

import java.util.UUID;

/**
 * This class holding the required fields for generating command
 * 
 * @author rusty
 *
 */
public abstract class Command extends Object {

	private static final long serialVersionUID = 1L;

	public abstract void superFicialValidator(Object data);

	public Command() {
		super(UUID.randomUUID().toString());
	}

}
