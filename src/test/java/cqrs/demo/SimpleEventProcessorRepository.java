package cqrs.demo;

import java.util.List;

public class SimpleEventProcessorRepository extends EventProcessor {

	@Override
	public void process(Event event) {
		List<EventListener> eventListeners = event.getRegisteredListener();
		System.out.println("[ Event  processed = " + event.getClass() + "]");
		eventListeners.stream().forEach(eventListener -> eventListener
				.onNewEvent(new String("Process with [" + eventListener.getClass() + "]")));
	}
}
