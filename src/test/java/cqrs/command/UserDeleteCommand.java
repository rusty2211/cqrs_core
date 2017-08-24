package cqrs.command;

import cqrs.core.object.CQRSObject;
import cqrs.core.object.Command;

public class UserDeleteCommand extends Command {

	private static final long serialVersionUID = 3375485571695868956L;

	private String testString;

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	@Override
	public void superFicialValidator(CQRSObject data) {
		// TODO Auto-generated method stub

	}

}
