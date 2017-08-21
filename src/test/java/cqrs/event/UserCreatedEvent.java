package cqrs.event;

import cqrs.core.object.CommandTracker;
import cqrs.core.object.Event;
import cqrs.event.listener.UserCreatedEventListener;

public class UserCreatedEvent extends Event {

	public UserCreatedEvent(CommandTracker commandTracker) {
		super(commandTracker);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void registerListener() {
		eventListeners.add(new UserCreatedEventListener());
		System.out.println(eventListeners);
	}

}
