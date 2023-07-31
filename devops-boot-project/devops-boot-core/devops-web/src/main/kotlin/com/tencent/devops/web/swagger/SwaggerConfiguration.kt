package com.tencent.devops.web.swagger

import org.springdoc.core.GroupedOpenApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController

/**
 * swagger配置类
 */
@Configuration(proxyBeanMethods = false)
class SwaggerConfiguration {

    @Value("\${spring.application.name:#{null}}")
    private val applicationName: String? = null

    @Value("\${spring.application.desc:#{null}}")
    private val applicationDesc: String? = null

    @Value("\${spring.application.version:#{null}}")
    private val applicationVersion: String? = null

    @Bean
    fun api(): GroupedOpenApi {
//        val apiInfo = ApiInfoBuilder()
//            .title(applicationName)
//            .description(applicationDesc)
//            .version(applicationVersion)
//            .build()
        return GroupedOpenApi.builder()//DocumentationType.OAS_30)
//            .apiInfo(apiInfo)
//            .select()
            .pathsToMatch("/api/**")
            .addOpenApiMethodFilter{
                method -> method.isAnnotationPresent(RestController::class.java)
            }
//            .apis(RequestHandlerSelectors.withClassAnnotation(RestController::class.java))
//            .paths(PathSelectors.any())
                .build()
    }
}
