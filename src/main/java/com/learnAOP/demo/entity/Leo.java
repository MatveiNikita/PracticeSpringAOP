package com.learnAOP.demo.entity;

import org.springframework.stereotype.Component;


public class Leo {
    String name;

    public Leo() {
        System.out.println("Create bean Leo");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
