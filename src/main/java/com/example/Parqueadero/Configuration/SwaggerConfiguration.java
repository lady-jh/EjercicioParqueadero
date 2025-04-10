package com.example.Parqueadero.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API de parqueadero")
                        .version("1.0")
                        .description("Descripción de la API de gestión de parqueaderos")
                        .contact(new Contact()
                                .name("Soporte API")
                                .email("ljcastanedao@ucundinamarca.edu.co")
                        )
                );
    }
}
