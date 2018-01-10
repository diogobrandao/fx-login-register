package org.academiadecodigo.bootcamp.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {

    Map <String, Service> serviceMap = new HashMap<>();
    public static ServiceRegistry instance = null;

    private ServiceRegistry(){

    }

    public static synchronized ServiceRegistry getInstance(){
        if(instance == null){
            instance = new ServiceRegistry();
        }
        return instance;
    }

    public void addService(String name, Service service){
        serviceMap.put(name,service);
    }

    public Service stringService(String name){
        return serviceMap.get(name);
    }

    public Service getServiceMap(String key) {
        return serviceMap.get(key);
    }
}
