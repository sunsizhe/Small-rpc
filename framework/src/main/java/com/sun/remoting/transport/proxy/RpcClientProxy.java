package com.sun.remoting.transport.proxy;

import com.sun.remoting.message.RpcRequest;
import com.sun.remoting.transport.netty.client.NettyRpcClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcClientProxy implements InvocationHandler {
    private final String inetHost;
    private final Integer port;

    public RpcClientProxy(String inetHost, Integer port) {
        this.inetHost = inetHost;
        this.port = port;
    }

    public <T> T getProxy(Class<T> clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法匹配条件时, 触发远程调用: Client发生request
        RpcRequest request = RpcRequest.builder()
                .interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameters(args)
                .paramTypes(method.getParameterTypes())
                .build();
        NettyRpcClient nettyRpcClient = new NettyRpcClient();
        return nettyRpcClient.connect(request, inetHost, port);
    }
}
