package com.arjunsk.asm.filtering;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class ClassFilterDriver {

  public static void main(String[] args) {
    byte[] b1 = new byte[1];
    ClassReader cr = new ClassReader(b1);

    ClassWriter cw = new ClassWriter(0);
    cr.accept(cw, 0);
    byte[] b2 = cw.toByteArray(); // b2 represents the same class as b1
  }
}
