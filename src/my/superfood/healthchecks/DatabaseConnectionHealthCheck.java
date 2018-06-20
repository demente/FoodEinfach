package my.superfood.healthchecks;

import com.codahale.metrics.health.HealthCheck;

import javax.sql.DataSource;

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
