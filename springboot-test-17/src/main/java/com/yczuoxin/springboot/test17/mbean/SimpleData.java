package com.yczuoxin.springboot.test17.mbean;

import javax.management.*;
import java.util.concurrent.atomic.AtomicLong;

import static javax.management.AttributeChangeNotification.ATTRIBUTE_CHANGE;

public class SimpleData extends NotificationBroadcasterSupport implements SimpleDataMBean,
        NotificationListener, NotificationFilter {

    private String data;

    private static final AtomicLong SEQUENCE = new AtomicLong();

    public SimpleData(){
        this.addNotificationListener(this, this, null);
    }

    @Override
    public void setData(String data) {
        String oldValue = this.data;
        this.data = data;
        Notification notification = new AttributeChangeNotification(this,
                SEQUENCE.incrementAndGet(),
                System.currentTimeMillis(),
                "data has been changed from " + oldValue + " to " + data,
                "data",
                String.class.getName(),
                oldValue,
                data);
        sendNotification(notification);
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public String displayData() {
        return data;
    }

    /**
     * 处理事件
     * @param notification
     * @param handback
     */
    @Override
    public void handleNotification(Notification notification, Object handback) {
        AttributeChangeNotification attributeChangeNotification = (AttributeChangeNotification) notification;
        String oldData = (String) attributeChangeNotification.getOldValue();
        String newData = (String) attributeChangeNotification.getNewValue();
        System.out.printf("The notification of data's attribute - old data : %s, new data : %s \n", oldData, newData);
    }

    /**
     * 判断事件是否关心
     * @param notification
     * @return
     */
    @Override
    public boolean isNotificationEnabled(Notification notification) {
        // 只关心 AttributeChangeNotification 通知，并且仅限于字段为 data
        if (AttributeChangeNotification.class.isAssignableFrom(notification.getClass())) {
            AttributeChangeNotification attributeChangeNotification = (AttributeChangeNotification) notification;
            return "data".equals(attributeChangeNotification.getAttributeName());
        }
        return false;
    }

    /**
     * 暴露通知
     * @return
     */
    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        return new MBeanNotificationInfo[]{
                new MBeanNotificationInfo(new String[]{ATTRIBUTE_CHANGE}, "data change info", "data is changing now")
        };
    }
}
