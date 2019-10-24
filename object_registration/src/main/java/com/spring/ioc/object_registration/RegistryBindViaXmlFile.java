package com.spring.ioc.object_registration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 通过xml配置方式
 */
public class RegistryBindViaXmlFile {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaXmlFile(beanRegistry);

        NewsProvider newsProvider = (NewsProvider) container.getBean("myNewsProvider");
        newsProvider.getAndPersistNews();
    }

    private static BeanFactory bindViaXmlFile(BeanDefinitionRegistry registry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

        reader.loadBeanDefinitions("classpath:news-config.xml");
        return (BeanFactory) registry;
    }
}
