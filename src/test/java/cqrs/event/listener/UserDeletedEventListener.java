package cqrs.event.listener;

import cqrs.core.event.listener.EventListener;

public class UserDeletedEventListener implements EventListener {

	@Override
	public void onNewEvent(java.lang.Object obj) {
		System.out.println(obj);
	}
}
