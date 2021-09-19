package com.demo.config;

import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    BasicErrorController c;
    
    @Bean
    public Docket mySwaggerConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select()

        // add package
        .apis(RequestHandlerSelectors.basePackage("com.demo"))
        // .apis(RequestHandlerSelectors.basePackage("org.springframework.boot.autoconfigure.web.servlet.error"))
.paths(PathSelectors.any())

        // add url
       // .paths(PathSelectors.ant("/v2/api/admin/**"))
        // .paths(PathSelectors.ant("/error"))

        .build()
        .apiInfo(
            new ApiInfoBuilder()
            .contact(new Contact("cts", "www.cts.com", "demo@cts.com"))
            .license("8763905325")
            .licenseUrl("www.cts.com/privacy/license")
            .version("3.5")
            .description("THIS IS ADMIN SERVICE PAGE")
            .title("ADMIN")
            .build()

        )
        ;
    }

}