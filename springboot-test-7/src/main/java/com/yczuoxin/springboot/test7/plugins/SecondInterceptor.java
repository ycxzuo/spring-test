package com.yczuoxin.springboot.test7.plugins;

import com.yczuoxin.springboot.test7.test.testInterface.IGetStr;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({@Signature(method = "getStrZero", type = IGetStr.class, args = {}),
        @Signature(method = "getStrOne", type = IGetStr.class, args = {})})
public class SecondInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return "plugin2  " + invocation.proceed() + "  plugin2";
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
