package com.wjy.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
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
		docket.globalOperationParameters(getParameterBuilder());

		return getApiSelectorBuilder(docket.select()).build();

	}

	/**
	 * 需扫描包
	 * 
	 * @param apiSelectorBuilder
	 * @return
	 */
	private ApiSelectorBuilder getApiSelectorBuilder(ApiSelectorBuilder apiSelectorBuilder) {

		// 扫描所有
		apiSelectorBuilder.apis(RequestHandlerSelectors.any());
		// 扫描包路径
		// apiSelectorBuilder.apis(RequestHandlerSelectors.basePackage("com.wjy.controller"));
		// 扫描类注解
		// apiSelectorBuilder.apis(RequestHandlerSelectors.withClassAnnotation(Api.class));
		// 扫描方法注解
		// apiSelectorBuilder.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class));
		apiSelectorBuilder.paths(PathSelectors.any());

		return apiSelectorBuilder;

	}

	/**
	 * 请求头配置
	 * 
	 * @return
	 */
	private List<Parameter> getParameterBuilder() {

		List<Parameter> parameters = new ArrayList<Parameter>();

		ModelRef modelRef = new ModelRef("string");

		ParameterBuilder parameterBuilder1 = new ParameterBuilder();
		ParameterBuilder parameterBuilder2 = new ParameterBuilder();

		Parameter parameter1 = parameterBuilder1.name("H-AuthorId").description("作者ID").parameterType("header")
				.defaultValue("H-AuthorId").modelRef(modelRef).required(true).build();
		Parameter parameter2 = parameterBuilder2.name("H-Token").description("Token").parameterType("header")
				.defaultValue("H-Token").modelRef(modelRef).required(true).build();

		parameters.add(parameter1);
		parameters.add(parameter2);

		return parameters;

	}

	/**
	 * 接口文档注释
	 * 
	 * @return
	 */
	private ApiInfo getApiInfo() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title("Swagger2接口文档");
		apiInfoBuilder.description("Swagger2接口描述");
		apiInfoBuilder.version("1.0.0");
		apiInfoBuilder.contact(new Contact("ybxxszl", "https://www.baidu.com/", "1062837400@qq.com"));

		return apiInfoBuilder.build();

	}

}
