package com.arjunsk.asm.filter.allclasses;

import com.arjunsk.asm.filter.visiterimpl.support.ChangeVersionAdapter;
import java.lang.instrument.Instrumentation;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

/**
 *
 *
 * <pre>
 * To perform Transformation on all the classes, we might need to use premain().
 * Eg:- Lombok
 *
 * Refer 1: `ASM Guide` Page 21.
 * Refer 2: https://stackoverflow.com/questions/27851588/what-is-premain-and-how-does-it-get-called
 * </pre>
 *
 * <p>NOTE : In the asm guide there is an optimization performed. ClassWriter has reference to
 * ClassReader. This optimization is two times faster than the previous one {@link
 * com.arjunsk.asm.filter.visiterimpl.ClassFilterDriver2}, because ChangeVersionAdapter does not
 * transform any method.
 *
 * <pre>
 *    byte[] b1 = ...
 *    ClassReader cr = new ClassReader(b1);
 *    ClassWriter cw = new ClassWriter(cr, 0);
 *    ChangeVersionAdapter ca = new ChangeVersionAdapter(cw);
 *    cr.accept(ca, 0);
 *    byte[] b2 = cw.toByteArray();
 * </pre>
 */
public class AllClassTransformDriver {

  // Flow: (CR<->CW) --> CVA --> CR --> CW.toByteArray()
  public static void premain(String agentArgs, Instrumentation inst) {
    inst.addTransformer(
        (classLoader, name, aClass, domain, bytes) -> {

          // 1. CR <-> CW
          ClassReader cr = new ClassReader(bytes);
          ClassWriter cw = new ClassWriter(cr, 0);

          // 2. CVA
          ClassVisitor cv = new ChangeVersionAdapter(cw);

          // 3. CR
          cr.accept(cv, 0);

          // 4. CW
          return cw.toByteArray();
        });
  }

  public static void main(String[] args) {}
}
