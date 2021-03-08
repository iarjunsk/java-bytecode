package com.arjunsk.pattern.element;

import com.arjunsk.pattern.domain.ElementAction;
import com.arjunsk.pattern.visitor.FioriElementVisitor;

public interface FioriElement {

  void accept(FioriElementVisitor visitor, ElementAction action);
}
