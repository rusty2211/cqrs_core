package cqrs.demo;

/**
 * 
 * @author rusty
 *
 */
public class MariaConfiguration {
	private String host;
	private Long port;
	private String databaseName;

	public MariaConfiguration(String host, Long port, String databaseName) {
		this.host = host;
		this.port = port;
		this.databaseName = databaseName;

	}

	public String getHost() {
		return host;
	}

	public Long getPort() {
		return port;
	}

	public String getDatabaseName() {
		return databaseName;
	}

}
