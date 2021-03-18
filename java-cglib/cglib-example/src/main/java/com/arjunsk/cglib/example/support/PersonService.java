package com.arjunsk.cglib.example.support;

public class PersonService {
  public String sayHello(String name) {
    return "Hey " + name;
  }

  public Integer lengthOfName(String name) {
    return name.length();
  }
}
