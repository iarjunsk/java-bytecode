package com.arjunsk.asm.filter.allclasses;

import com.arjunsk.asm.filter.visiterimpl.support.ChangeVersionAdapter;
import java.lang.instrument.Instrumentation;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

public class AllClassTransformDriver {

  public static void premain(String agentArgs, Instrumentation inst) {
    inst.addTransformer(
        (classLoader, name, aClass, domain, bytes) -> {
          ClassReader cr = new ClassReader(bytes);

          ClassWriter cw = new ClassWriter(cr, 0);
          ClassVisitor cv = new ChangeVersionAdapter(cw);

          cr.accept(cv, 0);
          return cw.toByteArray();
        });
  }

  public static void main(String[] args) {}
}
