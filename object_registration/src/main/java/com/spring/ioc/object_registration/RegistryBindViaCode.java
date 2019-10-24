package com.spring.ioc.object_registration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 直接编码方式
 */
public class RegistryBindViaCode {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanFactory);
        NewsProvider newsProvider = container.getBean(NewsProvider.class);
        newsProvider.getAndPersistNews();
    }

    private static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(NewsProvider.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(MyNewsListenerImpl.class);

        registry.registerBeanDefinition("myNewsProvider", newsProvider);
        registry.registerBeanDefinition("myNewsListener", newsListener);

        //构造方法注入
        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0, newsListener);
        newsProvider.setConstructorArgumentValues(argValues);


        return (BeanFactory) registry;
    }
}
