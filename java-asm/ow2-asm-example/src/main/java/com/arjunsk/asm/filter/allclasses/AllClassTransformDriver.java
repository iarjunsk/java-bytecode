package com.arjunsk.asm.filter.allclasses;

import com.arjunsk.asm.filter.visiterimpl.support.ChangeVersionAdapter;
import java.lang.instrument.Instrumentation;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

/**
 * To introduce all class Transformation, we might need premain().
 *
 * <p>Eg:- Lombok
 *
 * <p>Refer 1: `ASM Guide` Page 21.
 *
 * <p>Refer 2:
 * https://stackoverflow.com/questions/27851588/what-is-premain-and-how-does-it-get-called
 */
public class AllClassTransformDriver {

  // Flow: CR --> CVA --> CW --> toByteArray()
  public static void premain(String agentArgs, Instrumentation inst) {
    inst.addTransformer(
        (classLoader, name, aClass, domain, bytes) -> {

          // 1. CW
          ClassWriter cw = new ClassWriter(0);

          // 2. CVA
          ClassVisitor cv = new ChangeVersionAdapter(cw);

          // 3. CR
          ClassReader cr = new ClassReader(bytes);
          cr.accept(cv, 0);

          // Lazy function. The final chain of invocation will only start at toByteArray() call.
          return cw.toByteArray();
        });
  }

  public static void main(String[] args) {}
}
