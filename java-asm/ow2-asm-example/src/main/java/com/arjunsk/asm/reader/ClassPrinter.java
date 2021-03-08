package com.arjunsk.asm.reader;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM4;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class ClassPrinter extends ClassVisitor {

  public ClassPrinter() {
    super(ASM4);
  }

  @Override
  public void visit(
      int version,
      int access,
      String name,
      String signature,
      String superName,
      String[] interfaces) {
    System.out.println(
        "visit() : "
            + version
            + " "
            + access
            + " "
            + name
            + " "
            + signature
            + " "
            + superName
            + " interfaces: "
            + String.join("|", interfaces));

    super.visit(version, access, name, signature, superName, interfaces);
  }

  @Override
  public void visitSource(String source, String debug) {
    System.out.println("visitSource() : " + source + " " + debug);
    super.visitSource(source, debug);
  }

  @Override
  public void visitOuterClass(String owner, String name, String desc) {
    System.out.println("visitOuterClass() : " + owner + " " + name + " " + desc);
    super.visitOuterClass(owner, name, desc);
  }

  @Override
  public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
    System.out.println("visitAnnotation() : " + desc + " " + visible);
    return super.visitAnnotation(desc, visible);
  }

  @Override
  public void visitAttribute(Attribute attr) {
    System.out.println("visitAttribute() : " + attr.toString());
    super.visitAttribute(attr);
  }

  @Override
  public void visitInnerClass(String name, String outerName, String innerName, int access) {
    System.out.println(
        "visitInnerClass() : " + name + " " + outerName + " " + innerName + " " + access);
    super.visitInnerClass(name, outerName, innerName, access);
  }

  @Override
  public FieldVisitor visitField(
      int access, String name, String desc, String signature, Object value) {
    System.out.println(
        "visitField() : " + access + " " + name + " " + desc + " " + signature + " " + value);
    return super.visitField(access, name, desc, signature, value);
  }

  @Override
  public MethodVisitor visitMethod(
      int access, String name, String desc, String signature, String[] exceptions) {
    System.out.println(
        "visitMethod() : " + access + " " + name + " " + desc + " " + signature + " " + exceptions);
    return super.visitMethod(access, name, desc, signature, exceptions);
  }

  @Override
  public void visitEnd() {
    System.out.println("visitEnd() : ");
    super.visitEnd();
  }
}
