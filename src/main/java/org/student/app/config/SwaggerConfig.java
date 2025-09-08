package org.student.app.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Student Application",
        version = "1.0",
        description = "REST API for managing students"
    )
)
public class SwaggerConfig {

}
