package com.arjunsk.asm.filter.visiterimpl;

import com.arjunsk.asm.filter.visiterimpl.support.ChangeVersionAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

// Flow: CR --> CVA --> CW --> toByteArray()
public class ClassFilterDriver2 {

  public static void main(String[] args) {
    // 1. CW
    ClassWriter classWriter = new ClassWriter(0);

    // 2. CVA
    /* classVisitor forwards all events to classWriter.*/
    ChangeVersionAdapter changeVersionAdapter = new ChangeVersionAdapter(classWriter);

    // 3. CR
    byte[] inputClass = new byte[1];
    ClassReader classReader = new ClassReader(inputClass);
    classReader.accept(changeVersionAdapter, 0);

    // b2 represents the same class as b1
    byte[] outputClass = classWriter.toByteArray();
  }
}
