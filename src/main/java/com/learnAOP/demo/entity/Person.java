package com.learnAOP.demo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
public class Person {

    private Leo leo;

    String name;
    @Autowired
    public Person(@Qualifier("Greg") Leo leo){
        this.leo = leo;
    }
    public Leo getLeo() {
        return leo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeo(Leo leo) {
        this.leo = leo;
    }
}
