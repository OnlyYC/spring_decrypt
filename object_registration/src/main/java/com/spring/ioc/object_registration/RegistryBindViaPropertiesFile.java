package com.spring.ioc.object_registration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * 通过properties方式
 */
public class RegistryBindViaPropertiesFile {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaPropertiesFile(beanRegistry);

        NewsProvider newsProvider = (NewsProvider) container.getBean("myNewsProvider");
        newsProvider.getAndPersistNews();
    }

    private static BeanFactory bindViaPropertiesFile(BeanDefinitionRegistry registry) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(registry);

        reader.loadBeanDefinitions("classpath:binding-config.properties");
        return (BeanFactory) registry;
    }
}
