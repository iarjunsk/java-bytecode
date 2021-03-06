package com.arjunsk.pattern.domain;

import com.arjunsk.pattern.enums.ElementOperation;

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
   * <p>Eg:- {@link com.arjunsk.pattern.element.imp.TextFieldFioriElement}
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
