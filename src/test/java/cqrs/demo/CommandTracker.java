package cqrs.demo;

import java.util.UUID;

/**
 * This class hold the command meta data for events
 * 
 * @author rusty
 *
 */
public final class CommandTracker extends Object {
	private static final long serialVersionUID = 9012504407082752924L;

	private String aggregateType;// name of the command's class
	private String aggregateId; // generated id of command class

	public CommandTracker(Command command) {
		super(UUID.randomUUID().toString());
		this.aggregateType = command.getClass().getName();
		this.aggregateId = command.getId();
	}

	public String getAggregateId() {
		return aggregateId;
	}

	public String getAggregateType() {
		return aggregateType;
	}

	public static void main(String[] args) {
		Command command = new UserAddCommand();
		System.out.println(command.getClass().getName());
	}

}
