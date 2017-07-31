package cqrs.demo;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is the base object for commands and events
 * 
 * @author rusty
 *
 */
public class Object implements Serializable {

	private static final long serialVersionUID = -2999684812201494508L;
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final Logger LOGGER = LoggerFactory.getLogger(Object.class.getName());

	private String id;

	public Object(String id) {
		this.id = id;

	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

	public String toJson() {
		try {
			MAPPER.writeValueAsString(this);
		} catch (Exception e) {
			LOGGER.error("Convert object[" + this.getClass() + "] to JSON context", e);
		}
		return null;
	}
}
