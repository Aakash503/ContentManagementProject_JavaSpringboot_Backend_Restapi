/*
 * Author Name: Jaival
 * Date: 06-12-2022
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.apiGatewayDemo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator getRoutes(RouteLocatorBuilder builder)
    {
        return builder.routes().route(p->p.path("/api/v1/**").uri("http://localhost:8085/"))
                .route(p->p.path("/api/v1/**").uri("http://localhost:8082/")).build();
    }
}
