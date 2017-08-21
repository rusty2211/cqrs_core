package cqrs.core.object;

import java.util.UUID;

/**
 * This class holding the required fields for generating command
 * 
 * @author rusty
 *
 */
public abstract class Command extends cqrs.core.object.Object {

	private static final long serialVersionUID = 1L;

	public abstract void superFicialValidator(cqrs.core.object.Object data);

	public Command() {
		super(UUID.randomUUID().toString());
	}

}
