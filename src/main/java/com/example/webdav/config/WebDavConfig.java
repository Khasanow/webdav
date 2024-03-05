package com.example.webdav.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "webdav")
public class WebDavConfig {
    private String username;
    private String password;
    private String root;
}
