package com.hitProject.hitDemo.config;

import com.hitProject.hitDemo.interceptor.HitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Autowired
    private HitInterceptor hitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
       interceptorRegistry.addInterceptor(hitInterceptor)
               .addPathPatterns("/**");// intercept all ways
    }

}
