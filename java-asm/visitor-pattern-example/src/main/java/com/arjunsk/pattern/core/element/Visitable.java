package com.arjunsk.pattern.core.element;

import com.arjunsk.pattern.domain.ElementAction;

/** Visitable Accepts Visitor. */
public interface Visitable<T> {

  void accept(T visitor, ElementAction action);
}
