package com.springboot.system.Library.services;


import com.springboot.system.Library.entities.Subscriber;
import com.springboot.system.Library.repository.SubscriberRepository;
import com.springboot.system.Library.services.interfaces.SubscriberInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsrciberService implements SubscriberInterfaceService {

    @Autowired
    private final SubscriberRepository subscriberRepository;

    public SubsrciberService(SubscriberRepository subscriberRepository){
        this.subscriberRepository = subscriberRepository;
    }

    public List<Subscriber> getAllSubscribers(){
        return this.subscriberRepository.findAll();
    }

    public Subscriber createSubscriber(Subscriber subscriber){
        return this.subscriberRepository.save(subscriber);
    }
}
