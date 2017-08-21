package cqrs.event.listener;

import cqrs.core.event.listener.EventListener;

public class UserCreatedEventListener implements EventListener {

	@Override
	public void onNewEvent(java.lang.Object obj) {
		System.out.println(obj);
	}
}
