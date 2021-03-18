package com.arjunsk.asm.asmifier;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

public class TestDriver {

  /** Prints the ASM code to generate the class. */
  public static void main(String[] args) throws IOException {

    InputStream resourceAsStream = TestDriver.class.getResourceAsStream("support/Example.class");
    ClassReader cr = new ClassReader(resourceAsStream);

    TraceClassVisitor cv = new TraceClassVisitor(null, new ASMifier(), new PrintWriter(System.out));

    cr.accept(cv, 0);
  }
}
