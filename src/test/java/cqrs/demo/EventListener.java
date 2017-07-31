package cqrs.demo;

/**
 * The common API implemented by the company's departments (the <b>Observer</b>)
 * to get notified when a new job is available.
 *
 * @author rusty
 */
public interface EventListener {

	/**
	 * Invoked when a new event is available with the specific information.
	 *
	 * @param info
	 *            the event's information
	 */
	public void onNewEvent(java.lang.Object obj);
}
