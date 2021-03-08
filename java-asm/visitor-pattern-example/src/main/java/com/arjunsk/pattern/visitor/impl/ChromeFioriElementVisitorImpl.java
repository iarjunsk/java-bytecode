package com.arjunsk.pattern.visitor.impl;

import com.arjunsk.pattern.domain.ElementAction;
import com.arjunsk.pattern.element.imp.ButtonFioriElement;
import com.arjunsk.pattern.element.imp.TextFieldFioriElement;
import com.arjunsk.pattern.visitor.FioriElementVisitor;

/** Separate's Component Logic from Domain Class. */
public class ChromeFioriElementVisitorImpl implements FioriElementVisitor {

  /** {@inheritDoc} */
  @Override
  public void visit(TextFieldFioriElement textField, ElementAction action) {
    System.out.println(action.getOperation() + " on " + textField.getText() + " Text Field.");
  }

  /** {@inheritDoc} */
  @Override
  public void visit(ButtonFioriElement button, ElementAction action) {
    System.out.println(action.getOperation() + " on " + button.getText() + " Button.");
  }
}
