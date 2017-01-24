package org.xanyook.xabook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().apiInfo(apiInfo())
        // TODO : pour supprimer la structure de base de spring boot sur les
        // erreurs.
        // .useDefaultResponseMessages( false )
        ;
    }

    private ApiInfo apiInfo() {
        final SwaggerProperties swaggerProperties = getSwaggerProperties();
        final ApiInfo apiInfo = new ApiInfo(swaggerProperties.getTitle(), swaggerProperties.getDescription(), swaggerProperties.getVersion(), swaggerProperties.getTermsOfServiceUrl(),
                swaggerProperties.getContact(), swaggerProperties.getLicense(), swaggerProperties.getLicenseUrl());
        return apiInfo;
    }

    @Bean
    public SwaggerProperties getSwaggerProperties() {
        return new SwaggerProperties();
    }

}
