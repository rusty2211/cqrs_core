package cqrs.core.object;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import cqrs.core.event.listener.EventListener;

/**
 * This class holding the required fields for generating event
 * 
 * @author rusty
 *
 */
public abstract class Event extends cqrs.core.object.Object {
	private static final long serialVersionUID = 686243833737753329L;

	/**
	 * Register listeners/observers to receive notifications on event creation
	 *
	 * @param listener
	 *            the listener
	 */
	public abstract void registerListener();

	private String eventType;// typically the name of the class containing event
								// data
	private String aggregateType;// name of the command's class
	private String aggregateId; // generated id of command class
	private Long createdAt;
	private TimeZone timeZone;
	private String requester;// requester id
	// handle concurrency conflicts and partial connection scenarios.
	private Long version;// event version
	// groups events triggered in a single transaction(transaction id)
	private Long txId;
	// this list hold the the listeners for generated event
	protected List<EventListener> eventListeners = new ArrayList<>();

	public Event(CommandTracker commandTracker) {
		super(UUID.randomUUID().toString());// generated eventId
		this.eventType = this.getClass().getName();
		this.aggregateId = commandTracker.getId();
		this.aggregateType = commandTracker.getClass().getName();
		registerListener();
	}

	public List<EventListener> getRegisteredListener() {
		return eventListeners;
	}

	public String getEventType() {
		return eventType;
	}

	public String getRequester() {
		return requester;
	}

	public Long getTxId() {
		return txId;
	}

	public Long getVersion() {
		return version;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public String getAggregateType() {
		return aggregateType;
	}

	public String getAggregateId() {
		return aggregateId;
	}
}
