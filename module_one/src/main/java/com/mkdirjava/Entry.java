package com.mkdirjava;

import com.mkdirjava.module.two.IService;
import com.mkdirjava.module.two.IModuleTwoServiceImpl;
import com.mkdirjava.module.three.IModuleThreeServiceImpl;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Entry {
    public static void main(String[] args) throws IOException {
        IService iServiceFromModuleTwo = new IModuleTwoServiceImpl();
        IService iServiceFromModuleThree = new IModuleThreeServiceImpl();
        System.out.println(iServiceFromModuleTwo.getMyMessage());
        System.out.println(iServiceFromModuleThree.getMyMessage());
        var server = HttpServer.create(new InetSocketAddress(getPort()),0);
        server.createContext("/",(exchange)->{
            var messageBytes = iServiceFromModuleTwo.getMyMessage().getBytes();
            var responseWriter = exchange.getResponseBody();
            exchange.sendResponseHeaders(200,messageBytes.length);
            responseWriter.write(messageBytes);
            responseWriter.flush();
            responseWriter.close();
        });
        server.start();
    }

    private static int getPort() {
        var port = System.getenv().get("PORT");
        if(port == null ){
            throw new IllegalStateException("Application needs a PORT env to run");
        }
        try{
            return Integer.parseInt(port);
        }catch (Exception e){
            throw new IllegalStateException("PORT env needs to be a number");
        }
    }
}
