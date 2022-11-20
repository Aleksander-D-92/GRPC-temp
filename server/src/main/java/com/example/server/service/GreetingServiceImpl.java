package com.example.server.service;

import com.example.server.GreetingRequest;
import com.example.server.GreetingResponse;
import com.example.server.GreetingServiceGrpc;
import com.shopping.stubs.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        System.out.println(request.getMessage());
        var resp = GreetingResponse.newBuilder()
                .setMessage("Hello from server " + request.getMessage())
                .build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
