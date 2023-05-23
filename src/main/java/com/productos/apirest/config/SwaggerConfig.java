package com.productos.apirest.config;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.productos.apirest.resources"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("API REST Busqueda|Filtrado")
                .description("Servicios de búsqueda y filtrado de productos")
                .version("1.0")
                .license("Licencia de API")
                .licenseUrl("https://swagger.io/docs/")
                .build();
        return apiInfo;
    }
}

