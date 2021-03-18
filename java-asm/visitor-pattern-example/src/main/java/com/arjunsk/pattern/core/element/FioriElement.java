package com.arjunsk.pattern.core.element;

import com.arjunsk.pattern.core.visitor.FioriElementVisitor;

/** Include Generic Fiori Element Skeleton. */
public interface FioriElement extends Visitable<FioriElementVisitor> {

  String getId();
}
