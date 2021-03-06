package com.arjunsk.asm.classloader;

import java.lang.reflect.Field;

/**
 * OUTPUT
 *
 * <pre>
 * package pkg;
 * public interface Comparable extends Measurable {
 *  int LESS = -1;
 *  int EQUAL = 0;
 *  int GREATER = 1;
 *  int compareTo(Object o);
 * }
 * </pre>
 */
public class ClassWriterDriver {

  public static void main(String[] args) throws ClassNotFoundException {
    CustomClassLoader customClassLoader = new CustomClassLoader();
    Class loadedClass = customClassLoader.findClass("pkg.proxy.Comparable");

    System.out.println(loadedClass.getName());
    for (Field field : loadedClass.getFields()) {
      System.out.println("Field " + field.getName());
    }
  }
}
