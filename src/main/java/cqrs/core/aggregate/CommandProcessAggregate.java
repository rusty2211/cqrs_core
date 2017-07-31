package cqrs.core.aggregate;

import cqrs.core.command.Command;

/**
 *
 * This class handle to process the command and generate event accordingly and
 * process them
 * 
 * @author rusty
 *
 * @param <T>
 */
public interface CommandProcessAggregate<T extends Command> extends Aggregate<T> {

	public void processCommand(T cmd);

}
