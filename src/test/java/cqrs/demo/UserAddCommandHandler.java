package cqrs.demo;

import java.util.List;

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
