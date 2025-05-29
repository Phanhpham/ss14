package com.data.demo14.config;



import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.data.demo14.controller",
        "com.data.demo14.service",
        "com.data.demo14.repository"})
public class AppConfig {
    private static final String HOST_NAME = "dfqukquzq";
    private static final String API_KEY = "394125328536348";
    private static final String API_SECRET = "_68GygoqWG3qq-MR1nK5KQlNpoY";
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new
                InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", HOST_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET,
                "secure", true
        ));
    }
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760); // 10MB
        return multipartResolver;
    }
}

