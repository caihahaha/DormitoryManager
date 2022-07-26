package com.gdut.dormitory_system.config;

import com.gdut.dormitory_system.controller.interceptor.LoginRequiredInterceptor;
import com.gdut.dormitory_system.controller.interceptor.LoginTicketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @Author: zwj
 * @Date: 2022/7/23 16:32
 * @Description:
 */

/*
 * 旧项目需要转SpringBoot，需要定义此配置类，覆盖默认的视图解析器。
 * 在此类中不添加@EnableWebMvc注解，则会保留SpringBoot原本的Mvc配置；否则，会覆盖所有的SpringBoot对Spring MVC的默认配置。
 *
 * 在application.properties中配置：spring.mvc.view.prefix/spring.mvc.view.suffix是没有作用的！！！
 *
 */
@Configuration
public class PersonalMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;

    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/jsp/", ".jsp");
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginTicketInterceptor)
                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg")
                .excludePathPatterns("/login");

        registry.addInterceptor(loginRequiredInterceptor)
                .excludePathPatterns("/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg")
                .excludePathPatterns("/login");
    }
}