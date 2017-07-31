package cqrs.demo;

import java.util.List;

/**
 * 
 * @author rusty
 *
 * @param <C>
 */
public interface CommandHandler<C extends Command> {

	Class<C> getCommandClass();

	List<Event> validate(C cmd, CommandTracker commandTracker) throws ValidationException;

	CommandTracker getCommandTracker(C cmd);

	default List<Event> validate(C cmd) throws ValidationException {
		CommandTracker commandTracker = getCommandTracker(cmd);
		if (commandTracker == null) {
			throw new ValidationException("CommandTracker should not be null");
		}
		return validate(cmd, getCommandTracker(cmd));
	}

}
