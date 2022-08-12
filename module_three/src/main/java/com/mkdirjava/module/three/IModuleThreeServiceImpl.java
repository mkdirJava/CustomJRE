package com.mkdirjava.module.three;

import com.mkdirjava.module.two.IService;

public class IModuleThreeServiceImpl implements IService {

    @Override
    public String getMyMessage() {
        return "Message from Service Three";
    }
}
