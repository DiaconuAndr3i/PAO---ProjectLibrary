package com.springboot.system.Library.controller;

import com.springboot.system.Library.entities.Subscriber;
import com.springboot.system.Library.services.interfaces.SubscriberInterfaceService;
import org.springframework.web.bind.annotation.*;
import com.springboot.system.Library.services.SubsrciberService;

import java.util.List;

@RestController
@RequestMapping("/subscriber")
public class SubscriberController {

    private final SubscriberInterfaceService subscriberInterfaceService;

    public SubscriberController(SubscriberInterfaceService subscriberInterfaceService){
        this.subscriberInterfaceService = subscriberInterfaceService;
    }

    @GetMapping("/get")
    public List<Subscriber> getSubscribers(){
        return this.subscriberInterfaceService.getAllSubscribers();
    }

    @PostMapping("/create")
    public Subscriber createSubscriber(@RequestBody Subscriber subscriber){
        return this.subscriberInterfaceService.createSubscriber(subscriber);
    }
}
