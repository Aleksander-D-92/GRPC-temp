package com.example.client;

import com.example.client.grpc.UserClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(ClientApplication.class, args);
        var service = context.getBean(UserClient.class);
        service.call();
    }

}
