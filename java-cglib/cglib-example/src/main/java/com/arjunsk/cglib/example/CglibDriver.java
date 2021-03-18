package com.arjunsk.cglib.example;

import com.arjunsk.cglib.example.support.PersonService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

public class CglibDriver {

  public static void main(String[] args) {
    // Acts a proxy class
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(PersonService.class);
    enhancer.setCallback((FixedValue) () -> "Hello Tom!");
    PersonService proxy = (PersonService) enhancer.create();

    // Proxy class function replaces the actual class functions
    String res = proxy.sayHello(null);
    System.out.println(res);
  }
}
