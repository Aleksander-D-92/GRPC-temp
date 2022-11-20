package com.example.client.grpc;

import com.shopping.stubs.user.OrderRequest;
import com.shopping.stubs.user.UserRequest;
import com.shopping.stubs.user.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserClient {

    @GrpcClient("localhost:9090")
    private UserServiceGrpc.UserServiceBlockingStub client;

    public void call() {
        var req = UserRequest.newBuilder().setUsername("sasho").build();
        var req1 = OrderRequest.newBuilder().setUserId(12).build();
        var userResp = this.client.getUserDetails(req);
        var orderResp = this.client.getOrdersForUsers(req1);
        System.out.println(userResp);
        System.out.println(orderResp);
    }
}
