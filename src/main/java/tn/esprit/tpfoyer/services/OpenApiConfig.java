package tn.esprit.tpfoyer.services;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projet Foyer API Documentation")
                        .description("Documentation for TP Foyer Reservation Management API")
                        .version("v1.0"));
    }
}
