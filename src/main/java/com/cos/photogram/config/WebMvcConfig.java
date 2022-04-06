package com.cos.photogram.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.nio.file.Path;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer { // web setting file

    @Value("${file.path}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // file:///C:/Users/01/Desktop/seop/upload/
        registry
                .addResourceHandler("/upload/**") // occurs when /upload/** detected in jsp
                .addResourceLocations("file:///" + uploadFolder)
                .setCachePeriod(60 * 10 * 6)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}
