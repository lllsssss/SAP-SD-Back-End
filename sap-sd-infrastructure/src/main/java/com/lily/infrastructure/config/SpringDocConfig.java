package com.lily.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lll
 * @version 1.0
 * API文档相关配置
 */
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI sapSdApi() {
        return new OpenAPI()
            .info(new Info().title("SAP-SD后台管理系统")
                .description("SAP-SD API 演示")
                .version("v1.0.0")
                .license(new License().name("MIT 3.0").url("https://github.com/lllsssss/SAP-SD-Back-End")))
            .externalDocs(new ExternalDocumentation()
                .description("SAP-SD后台管理系统接口文档")
                .url("https://github.com/lllsssss"));
    }
}
