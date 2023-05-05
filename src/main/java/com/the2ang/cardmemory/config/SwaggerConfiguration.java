package com.the2ang.cardmemory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
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
    public Docket SwaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerInfo()) // API Docu 및 작성자 정보 매핑
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kepco.etax.api.controller"))
                .paths(PathSelectors.any()) // controller package 전부
                .paths(PathSelectors.ant("/api/v1/**"))
//                .paths(PathSelectors.ant("/api/v1/login"))
//                .paths(PathSelectors.ant("/api/v1/reissue"))
//                .paths(PathSelectors.ant("/api/v1/openapi/login"))// controller 패키지 내 v1만 택해서 할수도 있다.
//                .paths(PathSelectors.ant("/api/v1/openapi/reissue"))
//                .paths(PathSelectors.ant("/api/v1/openapi/createSaleTax"))
                .build()
                .useDefaultResponseMessages(false); // 기본 세팅값인 200, 401, 402, 403, 404를 사용하지 않는다.
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("플레쉬 카드 학습하기")
                .description("플레쉬 카드 학습하기 API")
                .license("The2sang. All Rights Reserved.")
                .licenseUrl("the2sang.mysite.com")
                .version("1")
                .build();
    }
}