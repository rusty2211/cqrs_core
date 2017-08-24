package cqrs.core.event.processor;

import java.util.List;

import cqrs.core.object.Event;

public interface EventProcessor {

	public default void process(List<Event> events) {
		events.stream().forEach(event -> process(event));
	}

	public abstract void process(Event event);

}
