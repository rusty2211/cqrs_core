package cqrs.demo;

import java.util.List;

public abstract class EventProcessor {

	public void process(List<Event> events) {
		events.stream().forEach(event -> process(event));
	}

	public abstract void process(Event event);

}
