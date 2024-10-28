package com.proj.mideval.config;

import com.proj.mideval.filter.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor)
//                .addPathPatterns("/patients/**") // Apply JWT to all /patients endpoints
//                .excludePathPatterns("/auth/**", "/patients"); // Exclude login and registration endpoints
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
