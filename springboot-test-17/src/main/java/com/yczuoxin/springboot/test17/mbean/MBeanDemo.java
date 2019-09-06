package com.yczuoxin.springboot.test17.mbean;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MBeanDemo {
    public static void main(String[] args) throws Exception {
        // MBean 服务器 -> Agent Level
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        // 注册对象
        SimpleData simpleData = new SimpleData();

        // 注册名称
        ObjectName objectName = createObjectName(simpleData);

        // 注册 MBean - SimpleDataMBean
        mBeanServer.registerMBean(simpleData, objectName);

        Thread.sleep(Long.MAX_VALUE);
    }

    private static ObjectName createObjectName(SimpleData simpleData) throws MalformedObjectNameException {
        Class<? extends SimpleData> mBeanClass = simpleData.getClass();

        Package packageName = mBeanClass.getPackage();
        String className = mBeanClass.getSimpleName();

        return new ObjectName(packageName + ":type=" + className);
    }
}
