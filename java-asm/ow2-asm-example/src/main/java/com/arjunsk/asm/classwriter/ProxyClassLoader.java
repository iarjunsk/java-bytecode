package com.arjunsk.asm.classwriter;

import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_FINAL;
import static org.objectweb.asm.Opcodes.ACC_INTERFACE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.V1_5;

import org.objectweb.asm.ClassWriter;

public class ProxyClassLoader extends ClassLoader {

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {

    if (name.startsWith("pkg.proxy")) {
      byte[] byteArray = getCustomClassByteArray();
      return defineClass(name, byteArray, 0, byteArray.length);
    }
    return super.findClass(name);
  }

  private byte[] getCustomClassByteArray() {

    ClassWriter cw = new ClassWriter(0);

    /**
     * Start the interface {@link com.arjunsk.asm.classreader.ClassPrinter#visit(int, int, String,
     * String, String, String[])}
     *
     * <p>OUTPUT:
     *
     * <pre>
     *    package pkg;
     *    public interface Comparable extends Measurable {
     * </pre>
     */
    cw.visit(
        V1_5, // Java 1.5
        ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
        "pkg/proxy/Comparable", // Full Class Name with /
        null, // Generics <T>
        "java/lang/Object", // Interface extends Object (Super Class)
        new String[] {"com/arjunsk/asm/classwriter/support/Measurable"}); // interface name

    /** OUTPUT: int LESS = -1; */
    cw.visitField(
            ACC_PUBLIC + ACC_FINAL + ACC_STATIC,
            "LESS",
            "I",
            null, // Generics <T>
            new Integer(-1))
        // Since there is not annotation, we can directly call visitEnd() of Field
        // Visitor, without call to visitAnnotation() or visitAttribute()
        .visitEnd();

    /** OUTPUT: int EQUAL = 0; */
    cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I", null, new Integer(0))
        .visitEnd();

    /** OUTPUT: int GREATER = 1; */
    cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I", null, new Integer(1))
        .visitEnd();

    /** OUTPUT: int compareTo(Object o); */
    cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null)
        .visitEnd();

    cw.visitEnd();

    return cw.toByteArray();
  }
}
