package com.arjunsk.asm.classloader;

import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.V1_5;

import org.objectweb.asm.ClassWriter;

public class CustomClassLoader extends ClassLoader {

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {

    if (name.endsWith("_Stub")) {
      byte[] byteArray = getCustomClassByteArray();
      return defineClass(name, byteArray, 0, byteArray.length);
    }
    return super.findClass(name);
  }

  private byte[] getCustomClassByteArray() {

    ClassWriter cw = new ClassWriter(0);

    /**
     * Start the interface {@link com.arjunsk.asm.printer.ClassPrinter#visit(int, int, String,
     * String, String, String[])}
     */
    cw.visit(
        V1_5, // Java 1.5
        ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
        "pkg/Comparable", // Full Class Name with /
        null, // Generics <T>
        "java/lang/Object", // Interface extends Object (Super Class)
        new String[] {"pkg/Measurable"});
    cw.visitField(
            ACC_PUBLIC + ACC_FINAL + ACC_STATIC,
            "LESS",
            "I",
            null, // Generics <T>
            new Integer(-1))
        // Since there is not annotation, we can directly call visitEnd() of Field
        // Visitor, without call to visitAnnotation() or visitAttribute()
        .visitEnd();

    cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I", null, new Integer(0))
        .visitEnd();
    cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I", null, new Integer(1))
        .visitEnd();

    cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null)
        .visitEnd();

    cw.visitEnd();

    return cw.toByteArray();
  }
}
