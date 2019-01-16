package com.wjy.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Bean
    public Docket createRestApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.apiInfo(getApiInfo());

        return getApiSelectorBuilder(docket.select()).build();

    }

    private ApiSelectorBuilder getApiSelectorBuilder(ApiSelectorBuilder apiSelectorBuilder) {

        apiSelectorBuilder.apis(RequestHandlerSelectors.basePackage("com.wjy.controller"));
        apiSelectorBuilder.paths(PathSelectors.any());

        return apiSelectorBuilder;

    }

    private ApiInfo getApiInfo() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Swagger2接口文档");
        apiInfoBuilder.description("Swagger2接口描述");
        apiInfoBuilder.version("1.0.0");
        apiInfoBuilder.contact(new Contact("ybxxszl", "https://www.baidu.com/", "1062837400@qq.com"));

        return apiInfoBuilder.build();

    }

}
