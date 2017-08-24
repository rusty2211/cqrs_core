package cqrs.service;

import java.util.concurrent.ExecutionException;

import cqrs.command.UserAddCommand;
import cqrs.command.UserDeleteCommand;
import cqrs.command.handler.UserAddCommandHandler;
import cqrs.command.handler.UserDeleteCommandHandler;
import cqrs.core.command.handler.CommandHandlerRegistry;
import cqrs.core.command.processor.CommandProcessor;
import cqrs.core.exception.InitiateException;
import cqrs.core.exception.ValidationException;

public class App {
	// @Test
	public static void main(String[] args) throws ValidationException, InterruptedException, ExecutionException {
		try {
			handlerRegistry();
		} catch (InitiateException e) {
			e.printStackTrace();
		}
		CommandProcessor commandProcessor = new CommandProcessor();
		commandProcessor.process(new UserAddCommand());
		commandProcessor.process(new UserDeleteCommand());
	}

	private static void handlerRegistry() throws InitiateException {
		CommandHandlerRegistry.register(UserAddCommandHandler.class);
		CommandHandlerRegistry.register(UserDeleteCommandHandler.class);
	}
}
