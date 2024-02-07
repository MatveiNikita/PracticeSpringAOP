package com.learnAOP.demo.config;

import com.learnAOP.demo.entity.Leo;
import com.learnAOP.demo.entity.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan("com/learnAOP/demo")
public class ProjectConfig {
    @Bean
    @Qualifier("Mike")
    Leo leo(){
        Leo leo = new Leo();
        leo.setName("Mike");
        return leo;
    }

    @Bean
    @Qualifier("Grig")
    Leo leo1(){
        Leo leo = new Leo();
        leo.setName("Grig");
        return leo;
    }
}
