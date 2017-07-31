package cqrs.core.aggregate;

import java.util.Set;

import cqrs.core.command.Command;
import cqrs.core.event.Event;

public abstract class SimpleCommandProcessAggregate<C extends Command> implements CommandProcessAggregate<C> {
	public abstract Set<? extends Event> getCommandEvents(C cmd);

	public Set<? extends Event> processEvents(C cmd) {
		return getCommandEvents(cmd);
	}

	public void processCommand(C cmd) {
		processEvents(cmd);
	}

}
