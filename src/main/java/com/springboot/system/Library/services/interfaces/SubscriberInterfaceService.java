package com.springboot.system.Library.services.interfaces;

import com.springboot.system.Library.entities.Subscriber;

import java.util.List;

public interface SubscriberInterfaceService {

    List<Subscriber> getAllSubscribers();

    Subscriber createSubscriber(Subscriber subscriber);
}
