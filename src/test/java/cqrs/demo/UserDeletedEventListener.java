package cqrs.demo;

public class UserDeletedEventListener implements EventListener {

	@Override
	public void onNewEvent(java.lang.Object obj) {
		System.out.println(obj);
	}
}
