package com.yczuoxin.springboot.test17.mbean.dynamic;

import javax.management.*;

import static javax.management.MBeanOperationInfo.ACTION;

public class SimpleDynamicData implements DynamicMBean {

    private String value;

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        return value;
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        if ("value".equals(attribute.getName())) {
            this.value = (String) attribute.getValue();
        }
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        return null;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        return null;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        if ("displayValue".equals(actionName)) {
            return value;
        }
        return null;
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        return new MBeanInfo(this.getClass().getName(),
                "简单的自定义DynamicMBean",
                of(new MBeanAttributeInfo("value", String.class.getName(),"自定义动态属性value", true, true, false)),
                of(new MBeanConstructorInfo(this.getClass().getSimpleName(), "自定义构造器", new MBeanParameterInfo[0])),
                of(new MBeanOperationInfo("displayValue", "自定义 displayValue", new MBeanParameterInfo[0], String.class.getName(), ACTION)),
                new MBeanNotificationInfo[0]
        );
    }

    public <T> T[] of(T... array) {
        return array;
    }
}
