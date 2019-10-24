package com.spring.ioc.object_registration;

public class NewsProvider {
    private NewsListener newsListener;

    public void getAndPersistNews(){
        System.out.println(newsListener.getNews());
    }

    public NewsProvider(NewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public NewsListener getNewsListener() {
        return newsListener;
    }

    public void setNewsListener(NewsListener newsListener) {
        this.newsListener = newsListener;
    }
}
