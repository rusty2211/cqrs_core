package cqrs.command.handler;

import java.util.List;

import cqrs.command.UserAddCommand;
import cqrs.core.command.handler.CommandHandler;
import cqrs.core.exception.ValidationException;
import cqrs.core.object.CommandTracker;
import cqrs.core.object.Event;
import cqrs.core.utils.EventUtils;
import cqrs.event.UserCreatedEvent;

public class UserAddCommandHandler implements CommandHandler<UserAddCommand> {

	public Class<UserAddCommand> getCommandClass() {
		return UserAddCommand.class;
	}

	@Override
	public CommandTracker getCommandTracker(UserAddCommand cmd) {
		return new CommandTracker(cmd); 
	}

	@Override
	public List<Event> validate(UserAddCommand cmd, CommandTracker commandTracker) throws ValidationException {
		return EventUtils.events(new UserCreatedEvent(commandTracker));
	}

}
