package com.spring.ioc.object_registration;

public class MyNewsListenerImpl implements NewsListener {
    @Override
    public String getNews() {
        return "这是一条新闻";
    }
}
