package com.learnAOP.demo.main;

import com.learnAOP.demo.config.ProjectConfig;
import com.learnAOP.demo.entity.Person;
import com.learnAOP.demo.service.ProjectService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person x = context.getBean(Person.class);
        x.setName("Nikita");
        System.out.println(x.getName());
        System.out.println(x.getLeo().getName());
        ProjectService service = context.getBean(ProjectService.class);
        service.moov(x);
    }
}
