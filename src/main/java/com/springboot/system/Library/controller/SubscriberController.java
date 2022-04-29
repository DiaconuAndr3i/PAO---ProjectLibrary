package com.springboot.system.Library.controller;

import com.springboot.system.Library.entities.BookCopy;
import com.springboot.system.Library.entities.Subscriber;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.services.interfaces.SubscriberInterfaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.system.Library.services.SubsrciberService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    @PutMapping("/update/{id}")
    public ResponseEntity<Subscriber> updateSubscriber(@PathVariable(value = "id") Long id, @Valid @RequestBody Subscriber subscriber) throws NotFound {
        return this.subscriberInterfaceService.updateSubscriber(id, subscriber);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteSubscriber(@PathVariable(value = "id") Long id) throws NotFound {
        return this.subscriberInterfaceService.deleteSubscriber(id);
    }
}
