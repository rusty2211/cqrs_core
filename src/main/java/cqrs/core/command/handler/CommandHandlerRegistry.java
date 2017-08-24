package cqrs.core.command.handler;

import java.util.HashMap;
import java.util.Map;

import cqrs.core.exception.InitiateException;
import cqrs.core.object.Command;

/**
 * This class register {@link CommandHandler} with {@link Command}
 * 
 * @author Raghav
 *
 */
public abstract class CommandHandlerRegistry {
	private CommandHandlerRegistry() {
		// no args constructor
	}

	public static Map<Class<? extends Command>, CommandHandler<? extends Command>> registry = new HashMap<>();

	public static void register(Class<? extends CommandHandler<? extends Command>> commandHandlerClazz)
			throws InitiateException {
		if (commandHandlerClazz != null) {
			CommandHandler<? extends Command> commandHandler;
			try {
				commandHandler = commandHandlerClazz.newInstance();
				registry.put(commandHandler.getCommandClass(), commandHandler);
			} catch (InstantiationException | IllegalAccessException e) {
				throw new InitiateException(e);
			}

		}
	}

	public static <T extends Command> CommandHandler<? extends Command> getHandler(T command) {
		return getHandlerClass(command.getClass());
	}

	private static <T extends Command> CommandHandler<? extends Command> getHandlerClass(Class<T> command) {
		return command != null ? registry.get(command) : null;
	}

}
