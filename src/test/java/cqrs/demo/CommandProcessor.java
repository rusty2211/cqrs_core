package cqrs.demo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
		try {
			return ((CommandHandler<Cmd>) CommandHandlerRegistry.getHandler(cmd));
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws ValidationException, InterruptedException, ExecutionException {
		CommandProcessor commandProcessor = new CommandProcessor();
		commandProcessor.process(new UserAddCommand());
		commandProcessor.process(new UserDeleteCommand());
	}
}
