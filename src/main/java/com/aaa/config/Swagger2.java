package com.aaa.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: springboot
 * @description
 * @author: lc
 * @create: 2020-11-29 00:50
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aaa.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo()
    { return new
            ApiInfoBuilder()
            .title("用户管理接口API文档")
            .version("1.0")
            .build();
    }
}
