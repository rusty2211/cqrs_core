package cqrs.example.aggregate;

import java.util.Set;

import cqrs.core.aggregate.SimpleCommandProcessAggregate;
import cqrs.core.event.Event;
import cqrs.example.command.Command1;
import cqrs.example.command.Command3;

public class Command1Aggregate extends SimpleCommandProcessAggregate<Command1> {
	@Override
	public Set<? extends Event> getCommandEvents(Command1 cmd) {
		System.out.println("Command1 process");
		return null;
	}

	public Set<? extends Event> getCommandEvents(Command3 cmd) {
		System.out.println("Command3 process");
		return null;
	}

	public static void main(String[] args) {
		Command1Aggregate aggregate = new Command1Aggregate();
		aggregate.processCommand(new Command1());
		aggregate.processCommand(new Command3());
	}

}
