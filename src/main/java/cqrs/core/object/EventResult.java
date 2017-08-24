package cqrs.core.object;

import java.util.UUID;

/**
 * This class is responsible to generate the event result after saving to event
 * store
 * 
 * @author rusty
 *
 */
public final class EventResult extends CQRSObject {

	private static final long serialVersionUID = 1L;
	private String description;
	private Long version;

	public EventResult(Long version) {
		super(UUID.randomUUID().toString());
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getVersion() {
		return version;
	}

}
