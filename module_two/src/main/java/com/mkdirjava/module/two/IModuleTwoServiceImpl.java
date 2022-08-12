package com.mkdirjava.module.two;

public class IModuleTwoServiceImpl implements IService {
    @Override
    public String getMyMessage() {
        return "This is from module two";
    }
}
