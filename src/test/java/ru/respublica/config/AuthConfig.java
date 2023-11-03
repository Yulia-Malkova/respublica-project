package ru.respublica.config;

import org.aeonbits.owner.Config;

@AuthConfig.Sources({"classpath:auth.properties"})
public interface AuthConfig extends Config {
    @Key("login")
    String login();

    @Key("password")
    String password();
}
