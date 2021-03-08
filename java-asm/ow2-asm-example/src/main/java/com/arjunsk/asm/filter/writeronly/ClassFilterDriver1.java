package com.arjunsk.asm.filter.writeronly;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class ClassFilterDriver1 {

  // Example 1: With classReader accepting classWriter.
  public static void main(String[] args) {
    byte[] b1 = new byte[1];
    ClassReader classReader = new ClassReader(b1);

    ClassWriter classWriter = new ClassWriter(0);

    // Reader Accepts Both ClassWriter & ClassVisitor.
    classReader.accept(classWriter, 0);

    byte[] b2 = classWriter.toByteArray(); // b2 represents the same class as b1
  }


}
