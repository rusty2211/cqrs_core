package cqrs.core.event.store;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cqrs.core.event.listener.EventListener;
import cqrs.core.event.processor.EventProcessor;
import cqrs.core.object.Event;

public class SimpleEventProcessorRepository implements EventProcessor {
	private Logger LOG = LoggerFactory.getLogger(SimpleEventProcessorRepository.class.getName());

	@Override
	public void process(Event event) {
		List<EventListener> eventListeners = event.getRegisteredListener();
		LOG.info("[ Event  processed = " + event.getClass() + "]");
		eventListeners.stream()
				.forEach(eventListener -> eventListener.onNewEvent("Process with [" + eventListener.getClass() + "]"));
	}
}
