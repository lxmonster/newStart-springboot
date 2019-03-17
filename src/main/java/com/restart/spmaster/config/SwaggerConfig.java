package com.restart.spmaster.config;

import org.springframework.beans.factory.annotation.Value;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * 功能描述：
 *
 * @Auther 梁展鹏
 * @Date 2018/12/31 10:31
 */
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enableSwagger;

    public static final String VERSION = "1.0.0";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("麦优电商管理后台")
                .description("麦优电商管理后台（swagger-ui文档）")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("http://172.16.8.68/maiyouManage")
                .version(VERSION)
                .contact(new Contact("梁展鹏", "", "fsliangzp@163.com"))
                .build();
    }

//    @Bean
//    public Docket customImplementation() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
//                .build()
//                .apiInfo(apiInfo())
//                .enable(enableSwagger);
//    }

}
