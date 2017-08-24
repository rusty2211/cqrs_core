package cqrs.core.command.processor;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import cqrs.core.command.handler.CommandHandler;
import cqrs.core.command.handler.CommandHandlerRegistry;
import cqrs.core.event.processor.EventProcessor;
import cqrs.core.event.store.SimpleEventProcessorRepository;
import cqrs.core.exception.ValidationException;
import cqrs.core.object.Command;
import cqrs.core.object.CommandResult;
import cqrs.core.object.Event;

/**
 * This class responsible to handle command validate it using command handler
 * and get events
 * 
 * @author rusty
 *
 */
public class CommandProcessor {

	public <T extends Command> CompletableFuture<CommandResult<T>> process(T cmd) throws ValidationException {
		CompletableFuture<CommandResult<T>> cmdResultFuture = CompletableFuture
				.supplyAsync(() -> new CommandResult<T>(cmd));
		CommandHandler<T> commandHandler = getHandler(cmd);
		List<Event> events = commandHandler.validate(cmd);
		EventProcessor eventProcessor = new SimpleEventProcessorRepository();
		eventProcessor.process(events);
		return cmdResultFuture;
	}

	@SuppressWarnings("unchecked")
	private <Cmd extends Command> CommandHandler<Cmd> getHandler(Cmd cmd) {
		return ((CommandHandler<Cmd>) CommandHandlerRegistry.getHandler(cmd));
	}
}
