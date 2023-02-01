package com.cheolcheol.restfulwebservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
        info = @Info(
                title = "철철이 API 명세서",
                description = "API 명세서",
                version = "v1",
                contact = @Contact(
                        name = "Cheolcheol",
                        url = "http://www.cheolcheol.co.kr",
                        email = "dream113213@naver.com"
                )
        )
)

@Configuration
public class OpenApiConfig {
    //
}
