package com.arjunsk.asm.filter.sample2;

import com.arjunsk.asm.filter.sample2.support.ChangeVersionAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class ClassFilterDriver2 {

  public static void main(String[] args) {

    byte[] b1 = new byte[1];
    ClassReader classReader = new ClassReader(b1);

    // classVisitor forwards all events to classWriter
    ClassWriter classWriter = new ClassWriter(0);
    ChangeVersionAdapter changeVersionAdapter = new ChangeVersionAdapter(classWriter);

    classReader.accept(changeVersionAdapter, 0);

    byte[] b2 = classWriter.toByteArray(); // b2 represents the same class as b1
  }
}
