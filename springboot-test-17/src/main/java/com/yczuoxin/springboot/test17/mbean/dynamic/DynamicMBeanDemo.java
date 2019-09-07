package com.yczuoxin.springboot.test17.mbean.dynamic;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class DynamicMBeanDemo {
    public static void main(String[] args) throws Exception {
        // MBean 服务器 -> Agent Level
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        // 注册对象
        SimpleDynamicData simpleDynamicData = new SimpleDynamicData();

        // 注册名称
        ObjectName objectName = createObjectName(simpleDynamicData);

        // 注册 MBean - SimpleDataMBean
        mBeanServer.registerMBean(simpleDynamicData, objectName);

        Thread.sleep(Long.MAX_VALUE);
    }

    private static ObjectName createObjectName(Object simpleData) throws MalformedObjectNameException {
        Class<? > mBeanClass = simpleData.getClass();

        Package packageName = mBeanClass.getPackage();
        String className = mBeanClass.getSimpleName();

        return new ObjectName(packageName + ":type=" + className);
    }
}
