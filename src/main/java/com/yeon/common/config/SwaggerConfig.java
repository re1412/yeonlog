package com.yeon.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "형연홈마켓",
                description = "형연홈마켓 API 명세서",
                version = "v1.0"
        ),
        servers = @Server(url = "/", description = "Default Server URL")
)
public class SwaggerConfig {
    // Springdoc는 별도의 Docket이나 빈 등록 없이 자동 구성됨
    // 추가 설정이 필요할 경우 springdoc.properties를 사용하거나,
    // OpenApiCustomizer 등 확장 설정 클래스를 따로 작성
}