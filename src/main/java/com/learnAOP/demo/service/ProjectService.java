package com.learnAOP.demo.service;

import com.learnAOP.demo.entity.Person;
import com.learnAOP.demo.repository.Transport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final Transport transport;

    public ProjectService(@Qualifier("Track") Transport transport) {
        this.transport = transport;
    }
    public void moov(Person person) {
    transport.send(person);
    }
}
