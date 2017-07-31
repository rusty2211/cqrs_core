package cqrs.core.event.kafka;

import java.util.Set;

import cqrs.core.event.Event;
import cqrs.core.event.process.EventProcessor;

public class KafkaEventProcessor extends EventProcessor {

	@Override
	public void process(Set<? extends Event> events) {

	}

}
