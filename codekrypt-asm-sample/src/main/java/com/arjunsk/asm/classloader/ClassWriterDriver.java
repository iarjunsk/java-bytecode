package com.arjunsk.asm.classloader;

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
    Class result = customClassLoader.findClass("Comparable_Stub");

    System.out.println(result.getName());
  }
}
