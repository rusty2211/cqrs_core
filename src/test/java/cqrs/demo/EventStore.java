package cqrs.demo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface EventStore {

	<T extends Event, C extends Command> CompletableFuture<EventResult> save(Class<C> cmd, List<Event> events);

	<T extends Event> CompletableFuture<EventResult> find(String entityId);

	<T extends Event> CompletableFuture<EventResult> update(List<Event> events);

	Event recreateFromSnapshot(Class<?> clasz, Void snapshot);
}
