package com.harshitbhardwaj.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ServiceBController {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public ServiceBController(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
        restClient = restClientBuilder.build();
    }

    @GetMapping("/helloEureka")
    public String helloEureka() {
        var instances = discoveryClient.getInstances("service-a");
        System.out.println("Instances are -");
        System.out.println(instances);
        ServiceInstance serviceInstance = instances.getFirst();
        String serviceAResponse = restClient.get()
                .uri(serviceInstance.getUri() + "/helloWorld")
                .retrieve()
                .body(String.class);
        return serviceAResponse;
    }
}
