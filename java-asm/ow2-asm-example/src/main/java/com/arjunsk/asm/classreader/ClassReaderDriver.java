package com.arjunsk.asm.classreader;

import java.io.IOException;
import org.objectweb.asm.ClassReader;

/**
 * OUTPUT:
 *
 * <pre>
 * visit() : 52 33 com/arjunsk/asm/printer/model/RadioButton null java/lang/Object interfaces:
 * visitSource() : RadioButton.java null
 * visitField() : 18 text Ljava/lang/String; null null
 * visitField() : 18 isClickable Z null null
 * visitMethod() : 1 <init> (Ljava/lang/String;Z)V null null
 * visitMethod() : 1 getText ()Ljava/lang/String; null null
 * visitMethod() : 1 isClickable ()Z null null
 * visitEnd() :
 * </pre>
 */
public class ClassReaderDriver {
  public static void main(String[] args) throws IOException {
    ClassReader classReader = new ClassReader("com.arjunsk.asm.classreader.support.RadioButton");

    ClassPrinter classPrinter = new ClassPrinter();
    classReader.accept(classPrinter, 0);

    // NOTE: ClassWriter extends ClassVisitor. Simply but, ClassReader is a `visitable` and
    // ClassWriter, CustomClassPrinter all should be `visitor` to implement custom business logic.
  }
}
