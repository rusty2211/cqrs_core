package cqrs.core.command.handler;

import java.util.HashMap;
import java.util.Map;

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
			throws InstantiationException, IllegalAccessException {
		if (commandHandlerClazz != null) {
			CommandHandler<? extends Command> commandHandler = commandHandlerClazz.newInstance();
			registry.put(commandHandler.getCommandClass(), commandHandler);
		}
	}

	public static <T extends Command> CommandHandler<? extends Command> getHandler(T command)
			throws InstantiationException, IllegalAccessException {
		return command != null ? getHandler(command.getClass()) : null;
	}

	public static <T extends Command> CommandHandler<? extends Command> getHandler(Class<T> command)
			throws InstantiationException, IllegalAccessException {
		return getHandlerClass(command);
	}

	private static <T extends Command> CommandHandler<? extends Command> getHandlerClass(Class<T> command) {
		return command != null ? registry.get(command) : null;
	}

}
