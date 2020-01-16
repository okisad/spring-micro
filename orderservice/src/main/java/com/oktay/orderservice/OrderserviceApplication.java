package com.oktay.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@SpringBootApplication
@EnableEurekaClient
public class OrderserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderserviceApplication.class, args);
    }


    @Configuration
    class RestTemplateConfig {

        @Bean
        @LoadBalanced
        public RestTemplate restTemplate() {
            SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.eu.sony.com", 10080));
            clientHttpReq.setProxy(proxy);
            return new RestTemplate(clientHttpReq);
        }
    }


}
