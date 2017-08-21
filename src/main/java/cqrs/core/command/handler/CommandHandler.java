package cqrs.core.command.handler;

import java.util.List;

import cqrs.core.exception.ValidationException;
import cqrs.core.object.Command;
import cqrs.core.object.CommandTracker;
import cqrs.core.object.Event;

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
