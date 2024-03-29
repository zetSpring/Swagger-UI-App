package com.zuko.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("REST API v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zuko.swagger.controller"))
                .paths(PathSelectors.ant("/v1/**"))
                .build();
    }

    @Bean
    public Docket apiV2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("REST API v2")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zuko.swagger.controller"))
                .paths(PathSelectors.ant("/v2/**"))
                .build();
    }
}
