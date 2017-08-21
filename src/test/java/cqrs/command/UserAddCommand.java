package cqrs.command;

import cqrs.core.object.Command;

public class UserAddCommand extends Command {

	private static final long serialVersionUID = 4846872156182293096L;

	private String testString;

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	@Override
	public void superFicialValidator(cqrs.core.object.Object data) {

	}
}
