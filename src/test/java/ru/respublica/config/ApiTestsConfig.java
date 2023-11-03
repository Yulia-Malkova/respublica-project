package ru.respublica.config;

import org.aeonbits.owner.Config;

@ApiTestsConfig.Sources({"classpath:config.properties"})

public interface ApiTestsConfig extends Config {
    @Key("baseUrl")
    String baseUrl();

    @Key("basePath")
    String basePath();
}