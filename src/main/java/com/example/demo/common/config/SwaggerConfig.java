package com.example.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket wdAPI() {

        //添加head参数start
        ParameterBuilder lng = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        lng.name("Accept-Language").description("语言类型").modelRef(new ModelRef("string"))
                .parameterType("header").required(false).build();
        pars.add(lng.build());
        //添加head参数end

        return new Docket(DocumentationType.SWAGGER_2).groupName("sign").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any()).build();
    }

    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("测试数据中心").description("测试数据中心后端接口定义")
                .termsOfServiceUrl("http://www.ey.com/").contact("api-admin@cn.ey.com")
                .version("1.0").build();
    }
}
