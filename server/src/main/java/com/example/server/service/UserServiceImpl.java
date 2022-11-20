package com.example.server.service;

import com.shopping.stubs.user.Gender;
import com.shopping.stubs.user.Order;
import com.shopping.stubs.user.OrderRequest;
import com.shopping.stubs.user.OrderResponse;
import com.shopping.stubs.user.UserRequest;
import com.shopping.stubs.user.UserResponse;
import com.shopping.stubs.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        var resp = UserResponse.newBuilder()
                .setAge(12)
                .setId(1)
                .setUsername("aaaaaaa")
                .setName("sasho")
                .setGender(Gender.MALE)
                .build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void getOrdersForUsers(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        var resp = OrderResponse.newBuilder()
                .setOrderName("default-name")
                .addOrder(Order.newBuilder().setOrderId(1).setUserId(1).setNumOfElements("12").setTotalAmount(12.6D).build())
                .addOrder(Order.newBuilder().setOrderId(2).setUserId(1).setNumOfElements("11").setTotalAmount(12.6D).build())
                .addOrder(Order.newBuilder().setOrderId(3).setUserId(2).setNumOfElements("3").setTotalAmount(12.6D).build())
                .addOrder(Order.newBuilder().setOrderId(4).setUserId(2).setNumOfElements("4").setTotalAmount(12.6D).build())
                .addOrder(Order.newBuilder().setOrderId(5).setUserId(2).setNumOfElements("5").setTotalAmount(12.6D).build())
                .build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
