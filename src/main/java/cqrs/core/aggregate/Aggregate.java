package cqrs.core.aggregate;

import java.util.Set;

import cqrs.core.command.Command;
import cqrs.core.event.Event;

/**
 * This class handle to process the command and generate event accordingly and
 * process them
 * 
 * @author rusty
 *
 */
public interface Aggregate<C extends Command> {
	Set<? extends Event> processEvents(C cmd);
}
