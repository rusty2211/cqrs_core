package cqrs.demo;

public class UserAddCommand extends Command {
	private String testString;

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	@Override
	public void superFicialValidator(Object data) {

	}
}