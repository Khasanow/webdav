package com.example.webdav.config;

import com.github.sardine.SardineFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.github.sardine.Sardine;
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final WebDavConfig webDavConfig;
    @Bean
    public Sardine initSardine(){
        Sardine sardine = SardineFactory.begin(webDavConfig.getUsername(), webDavConfig.getPassword());
        return sardine;

    }
}
