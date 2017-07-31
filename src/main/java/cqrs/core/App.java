package cqrs.core;

import cqrs.example.command.Command1;
import cqrs.example.event.EventProcessor1;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		Command1 command1 = new Command1();

		EventProcessor1 eventProcessor1 = new EventProcessor1();

	}
}
