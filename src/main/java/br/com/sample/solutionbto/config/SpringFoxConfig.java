/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sample.solutionbto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 *
 * @author robertobernardo
 */
@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class SpringFoxConfig {                                    

	@Value("${info.app.name}")
	private String title;

	@Value("${info.app.version}")
	private String version;

	@Value("${info.app.description}")
	private String description;

	private static final String PATH_MAPPING = "/";

	private static final String PACKAGE_BASE = "br.com.sample.solutionbto.controller";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
														.apiInfo(apiInfo())
														.select()
														.apis(RequestHandlerSelectors.basePackage(PACKAGE_BASE))
														.paths(PathSelectors.any())
														.build()
														.pathMapping(PATH_MAPPING)
														.useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
									.title(title)
									.description(description)
									.version(version)
									.build();
	}

}