package com.liaoyb.spring.object_registration_annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过注解方式，需要向Spring配置文件增加一个触发器context:component-scan
 */
public class RegistryBindViaAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

        NewsProvider newsProvider = (NewsProvider) ctx.getBean("newsProvider");
        newsProvider.getAndPersistNews();
    }
}
