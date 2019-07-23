package com.yczuoxin.springboot.test7.test;

import com.yczuoxin.springboot.test7.plugins.FirstInterceptor;
import com.yczuoxin.springboot.test7.plugins.SecondInterceptor;
import com.yczuoxin.springboot.test7.test.testInterface.IGetStr;
import com.yczuoxin.springboot.test7.test.testInterface.impl.GetStrImpl;
import org.apache.ibatis.plugin.InterceptorChain;

public class TestMain {
    public static void main(String[] args) {
        InterceptorChain chain = new InterceptorChain();
        chain.addInterceptor(new FirstInterceptor());
        chain.addInterceptor(new SecondInterceptor());

        IGetStr getStr = new GetStrImpl();
        getStr = (IGetStr)chain.pluginAll(getStr);
        String one = getStr.getStrOne();
        System.out.println(one);

        String zero = getStr.getStrZero();
        System.out.println(zero);

    }
}
