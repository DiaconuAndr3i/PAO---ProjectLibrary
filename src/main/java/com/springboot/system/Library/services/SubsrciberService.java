package com.springboot.system.Library.services;


import com.springboot.system.Library.entities.Subscriber;
import com.springboot.system.Library.error.status.NotFound;
import com.springboot.system.Library.repository.SubscriberRepository;
import com.springboot.system.Library.services.interfaces.AuditInterfaceService;
import com.springboot.system.Library.services.interfaces.SubscriberInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubsrciberService implements SubscriberInterfaceService {

    @Autowired
    private final SubscriberRepository subscriberRepository;
    @Autowired
    private final AuditInterfaceService auditInterfaceService;

    public SubsrciberService(SubscriberRepository subscriberRepository,
                             AuditInterfaceService auditInterfaceService){
        this.subscriberRepository = subscriberRepository;
        this.auditInterfaceService = auditInterfaceService;
    }

    @Override
    public List<Subscriber> getAllSubscribers(){
        try {
            return this.subscriberRepository.findAll();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("get all subscribers");
        }
    }

    @Override
    public Subscriber createSubscriber(Subscriber subscriber){
        try {
            return this.subscriberRepository.save(subscriber);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            this.auditInterfaceService.createAction("create subscriber");
        }
    }

    @Override
    public ResponseEntity<Subscriber> updateSubscriber(Long id, Subscriber newSubscriber) throws NotFound{
        Subscriber subscriber = this.subscriberRepository.findById(id).orElseThrow(() -> new NotFound("Subscriber with id " + id + " doesn't exist"));

        subscriber.setSubscriberStatus(newSubscriber.getSubscriberStatus());
        subscriber.setAddress(newSubscriber.getAddress());
        subscriber.setFirstName(newSubscriber.getFirstName());
        subscriber.setLastName(newSubscriber.getLastName());
        subscriber.setNumberBooksBorrowed(newSubscriber.getNumberBooksBorrowed());
        subscriber.setPhoneNumber(newSubscriber.getPhoneNumber());

        this.auditInterfaceService.createAction("update subscriber");

        return ResponseEntity.ok(this.subscriberRepository.save(subscriber));
    }

    @Override
    public Map<String, Boolean> deleteSubscriber(Long id) throws NotFound{
        Subscriber subscriber = this.subscriberRepository.findById(id).orElseThrow(() -> new NotFound("Subscriber with id " + id + " doesn't exist"));

        this.subscriberRepository.delete(subscriber);

        Map<String, Boolean> res = new HashMap<>();
        res.put("Subscriber deleted", Boolean.TRUE);

        this.auditInterfaceService.createAction("delete subscriber");

        return res;
    }

}
