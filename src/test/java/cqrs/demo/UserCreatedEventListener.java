package cqrs.demo;

public class UserCreatedEventListener implements EventListener {

	@Override
	public void onNewEvent(java.lang.Object obj) {
		System.out.println(obj);
	}
}
