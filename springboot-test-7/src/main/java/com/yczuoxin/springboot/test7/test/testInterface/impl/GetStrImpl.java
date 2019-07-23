package com.yczuoxin.springboot.test7.test.testInterface.impl;

import com.yczuoxin.springboot.test7.test.testInterface.IGetStr;

public class GetStrImpl implements IGetStr {
    @Override
    public String getStrZero() {
        return "0";
    }

    @Override
    public String getStrOne() {
        return "1";
    }
}
