package com.liaoyb.spring.object_registration_annotation;

import org.springframework.stereotype.Component;

@Component
public class MyNewsListenerImpl implements NewsListener {
    @Override
    public String getNews() {
        return "这是一条新闻";
    }
}
