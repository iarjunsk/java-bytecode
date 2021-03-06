package com.arjunsk.asm.printer;

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
public class Driver {
  public static void main(String[] args) throws IOException {
    ClassPrinter classPrinter = new ClassPrinter();
    ClassReader classReader = new ClassReader("com.arjunsk.asm.printer.model.RadioButton");
    classReader.accept(classPrinter, 0);
  }
}
