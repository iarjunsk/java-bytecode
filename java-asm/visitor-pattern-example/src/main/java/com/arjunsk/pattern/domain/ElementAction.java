package com.arjunsk.pattern.domain;

import com.arjunsk.pattern.core.element.imp.TextFieldFioriElement;
import com.arjunsk.pattern.domain.support.ElementOperation;

public class ElementAction {

  private final ElementOperation operation;

  private String text;

  /** Constructor for non-argument Action. */
  public ElementAction(ElementOperation operation) {
    this.operation = operation;
  }

  /**
   * Constructor for argument Action.
   *
   * <p>Eg:- {@link TextFieldFioriElement}
   */
  public ElementAction(ElementOperation operation, String text) {
    this.operation = operation;
    this.text = text;
  }

  public ElementOperation getOperation() {
    return operation;
  }

  public String getText() {
    return text;
  }
}
