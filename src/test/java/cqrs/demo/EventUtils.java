package cqrs.demo;

import java.util.Arrays;
import java.util.List;

public class EventUtils {
	private EventUtils() {
		// no args constructor
	}

	/**
	 * This method responsible for taking events as a parmater and return as a
	 * list
	 * 
	 * @param events
	 * @return
	 */
	public static List<Event> events(Event... events) {
		return Arrays.asList(events);
	}
}
