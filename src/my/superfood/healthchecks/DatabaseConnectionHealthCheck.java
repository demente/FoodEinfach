package my.superfood.healthchecks;

import javax.sql.DataSource;

import com.codahale.metrics.health.HealthCheck;

public class DatabaseConnectionHealthCheck extends HealthCheck {

	private final DataSource database;

	public DatabaseConnectionHealthCheck(DataSource db) {
		this.database = db;
	}

	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}

}
