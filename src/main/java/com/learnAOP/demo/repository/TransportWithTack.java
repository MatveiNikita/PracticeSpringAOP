package com.learnAOP.demo.repository;

import com.learnAOP.demo.entity.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Track")
public class TransportWithTack implements Transport{
    @Override
    public void send(Person person) {
        System.out.println("Person "+person.getName()+" and Leo"+person.getLeo().getName()+" was transport with track");
    }
}
