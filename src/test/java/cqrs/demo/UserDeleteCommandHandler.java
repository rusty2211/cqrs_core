package cqrs.demo;

import java.util.List;

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
