package ru.respublica.tests;

import org.aeonbits.owner.ConfigFactory;
import ru.respublica.config.ApiTestsConfig;
import ru.respublica.config.AuthConfig;

public class TestBase {

    protected static final ApiTestsConfig apiConfig = ConfigFactory.create(ApiTestsConfig.class, System.getProperties());
    protected static final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

}
