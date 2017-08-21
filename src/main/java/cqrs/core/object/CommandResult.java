package cqrs.core.object;

import java.io.Serializable;
import java.util.UUID;

public final class CommandResult<Cmd extends Command> implements Serializable {

	private static final long serialVersionUID = 5319206967905616949L;

	private String id;
	private Cmd cmd;

	public CommandResult(Cmd cmd) {
		this.id = UUID.randomUUID().toString();
		this.cmd = cmd;
	}

	public String getId() {
		return id;
	}

	public void setCmd(Cmd cmd) {
		this.cmd = cmd;
	}

	public Cmd getCmd() {
		return cmd;
	}

	@Override
	public String toString() {
		return "[Command = " + cmd.getClass() + ", id =" + id + "]";
	}

}