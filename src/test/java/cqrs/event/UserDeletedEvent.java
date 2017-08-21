package cqrs.event;

import cqrs.core.object.CommandTracker;
import cqrs.core.object.Event;
import cqrs.event.listener.UserDeletedEventListener;

public class UserDeletedEvent extends Event {

	public UserDeletedEvent(CommandTracker commandTracker) {
		super(commandTracker);
	}

	private static final long serialVersionUID = -2734851580082916853L;

	@Override
	public void registerListener() {
		eventListeners.add(new UserDeletedEventListener());
		System.out.println(eventListeners);
	}

}
