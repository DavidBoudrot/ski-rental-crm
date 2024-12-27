package com.david;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.DataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;



// entry point into dropwizard projects is the extension of Application with a config passed in.
// config can store variables
public class InventoryManagementApplicationStart extends Application<InventoryManagementConfiguration> {
    public static void main(String[] args) throws Exception {
        new InventoryManagementApplicationStart().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<InventoryManagementConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(InventoryManagementConfiguration configuration, Environment environment) {
        // For now the database deployment solution is to just spin up an h2 database with the schema defined in migrations.sql
        DataSourceFactory dataSourceFactory = configuration.getDatabase();
        DataSource dataSource = dataSourceFactory.build(environment.metrics(), "database");
        executeMigrationsScript(dataSource);

    }

    private void executeMigrationsScript(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            InputStream scriptStream = getClass().getClassLoader().getResourceAsStream("migrations.sql");
            if (scriptStream == null) {
                throw new IOException("migrations.sql file not found in resources");
            }

            String script = new String(scriptStream.readAllBytes(), StandardCharsets.UTF_8);

            String[] statements = script.split(";");
            for (String statementLine : statements) {
                if (!statementLine.trim().isEmpty()) {
                    statement.execute(statementLine.trim());
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Error spinning up database with migrations.sql file", e);
        }
    }
}
