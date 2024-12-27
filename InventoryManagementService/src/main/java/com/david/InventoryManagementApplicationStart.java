package com.david;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

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
        // nothing to do yet
    }
}
