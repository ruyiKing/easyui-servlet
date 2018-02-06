package com.yrw.test.proxy.demo1;

import java.lang.reflect.Proxy;

/**
 * Created by frankie on 2017/6/30.
 */
public class TestDog {
    public static void main(String[] args) {

        Dog real = new Dog();
        IDog proxySubject = (IDog)Proxy.newProxyInstance(IDog.class.getClassLoader(),new Class[]{IDog.class},new ProxyHandler(real));
        proxySubject.jiaoSheng();


    }
}
