package cqrs.example.object;

import cqrs.core.object.AppObject;

public class Command1Object extends AppObject {
	private String objectName;
	private String objectId;

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

}
