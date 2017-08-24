package cqrs.core.object;

import java.util.UUID;

/**
 * This class holding the required fields for generating command
 * 
 * @author rusty
 *
 */
public abstract class Command extends CQRSObject {

	private static final long serialVersionUID = 1L;

	public abstract void superFicialValidator(CQRSObject data);

	public Command() {
		super(UUID.randomUUID().toString());
	}

}
