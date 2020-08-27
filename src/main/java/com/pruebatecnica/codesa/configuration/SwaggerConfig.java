package com.pruebatecnica.codesa.configuration;

import com.pruebatecnica.codesa.CodesaApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CodesaApplication.class.getPackage().getName() + ".controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata())
                .tags(new Tag("User Rest API", "Defines endpoints that do CRUD operations about User."));
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Recibos API")
                .description("Funcionalidades de recibos de pago de certificados")
                .version("1.0-SNAPSHOT")
                .termsOfServiceUrl("https://www.linkedin.com/in/stiven-castro-arias-004263162/").license("free")
                .contact(new Contact("Stiven CAstro", "hhttps://www.linkedin.com/in/stiven-castro-arias-004263162/", "stivencastroarias2@gmail.com"))
                .build();
    }

}
