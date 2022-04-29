package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Subscriber;
import com.springboot.system.Library.error.status.NotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface SubscriberInterfaceService {

    List<Subscriber> getAllSubscribers();
    Subscriber createSubscriber(Subscriber subscriber);
    ResponseEntity<Subscriber> updateSubscriber(Long id, Subscriber newSubscriber) throws NotFound;
    Map<String, Boolean> deleteSubscriber(Long id) throws NotFound;
}
