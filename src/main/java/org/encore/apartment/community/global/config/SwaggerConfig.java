package org.encore.apartment.community.global.config;

import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	private static final String BEARER_TOKEN_PREFIX = "Bearer";
	private static final String SECURITY_SCHEME_NAME = "authorization";

	@Bean
	public OpenAPI swaggerApi() {
		return new OpenAPI()
			.components(new Components()
				.addSecuritySchemes(SECURITY_SCHEME_NAME, new SecurityScheme()
					.name(SECURITY_SCHEME_NAME)
					.type(SecurityScheme.Type.HTTP)
					.scheme("bearer")
					.bearerFormat("JWT")))
				.addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
			.info(new Info()
				.title("wePT BackEnd Open API")
				.description("Description: Apartment Community Application API")
				.version("v1"));
	}

	@Bean
	public OperationCustomizer globalHandler() {
		return (operation, handlerMethod) -> {
			operation.addParametersItem(new Parameter()
				.in(ParameterIn.HEADER.toString())
				.schema(new StringSchema().name("Refresh-Token"))
				.name("Refresh-Token")
				.required(false));
			return operation;
		};
	}

}