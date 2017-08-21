package cqrs.command.handler;

import java.util.List;

import cqrs.command.UserDeleteCommand;
import cqrs.core.command.handler.CommandHandler;
import cqrs.core.exception.ValidationException;
import cqrs.core.object.CommandTracker;
import cqrs.core.object.Event;
import cqrs.core.utils.EventUtils;
import cqrs.event.UserDeletedEvent;

public class UserDeleteCommandHandler implements CommandHandler<UserDeleteCommand> {

	public Class<UserDeleteCommand> getCommandClass() {
		return UserDeleteCommand.class;
	}

	@Override
	public List<Event> validate(UserDeleteCommand cmd, CommandTracker commandTracker) throws ValidationException {
		return EventUtils.events(new UserDeletedEvent(commandTracker));
	}

	@Override
	public CommandTracker getCommandTracker(UserDeleteCommand cmd) {
		return new CommandTracker(cmd);
	}

}
