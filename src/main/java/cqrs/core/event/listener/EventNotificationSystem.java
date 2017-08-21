package cqrs.core.event.listener;

import cqrs.core.object.Event;

/**
 * The abstraction for the event system notification (the <b>Subject</b>).
 *
 * @author rusty
 */
public interface EventNotificationSystem {

	/**
	 * Notifies the registered listeners about the new internal event.
	 *
	 * @param info
	 *            contains information about the event
	 */
	void notify(Event info);
}
