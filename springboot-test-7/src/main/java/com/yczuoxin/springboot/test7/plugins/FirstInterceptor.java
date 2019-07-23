package com.yczuoxin.springboot.test7.plugins;

import com.yczuoxin.springboot.test7.test.testInterface.IGetStr;
import org.apache.ibatis.plugin.*;

import java.util.Properties;
@Intercepts({@Signature(method = "getStrZero", type = IGetStr.class, args = {}),
        @Signature(method = "getStrOne", type = IGetStr.class, args = {})})
public class FirstInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return "plugin1 " + invocation.proceed() + " plugin1";
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
