package com.liaoyb.spring.object_registration_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsProvider {
    @Autowired
    private NewsListener newsListener;

    public NewsProvider() {
    }

    public NewsListener getNewsListener() {
        return newsListener;
    }

    public void getAndPersistNews() {
        System.out.println(newsListener.getNews());
    }

    public NewsProvider(NewsListener newsListener) {
        this.newsListener = newsListener;
    }


    public void setNewsListener(NewsListener newsListener) {
        this.newsListener = newsListener;
    }
}
