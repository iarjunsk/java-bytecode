package com.arjunsk.asm.printer;

import java.io.IOException;
import org.objectweb.asm.ClassReader;

public class Driver {
  public static void main(String[] args) throws IOException {
    ClassPrinter classPrinter = new ClassPrinter();
    ClassReader classReader = new ClassReader("com.arjunsk.asm.printer.model.RadioButton");
    classReader.accept(classPrinter, 0);
  }
}
