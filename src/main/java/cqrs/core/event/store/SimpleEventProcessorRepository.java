package cqrs.core.event.store;

import java.util.List;

import cqrs.core.event.listener.EventListener;
import cqrs.core.event.processor.EventProcessor;
import cqrs.core.object.Event;

public class SimpleEventProcessorRepository extends EventProcessor {

	@Override
	public void process(Event event) {
		List<EventListener> eventListeners = event.getRegisteredListener();
		System.out.println("[ Event  processed = " + event.getClass() + "]");
		eventListeners.stream().forEach(eventListener -> eventListener
				.onNewEvent(new String("Process with [" + eventListener.getClass() + "]")));
	}
}
