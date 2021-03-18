package com.arjunsk.pattern.core.visitor.impl;

import com.arjunsk.pattern.core.element.imp.ButtonFioriElement;
import com.arjunsk.pattern.core.element.imp.TextFieldFioriElement;
import com.arjunsk.pattern.core.visitor.FioriElementVisitor;
import com.arjunsk.pattern.domain.ElementAction;

/** Separate's Component Logic from Domain Class. */
public class ChromeFioriElementVisitorImpl implements FioriElementVisitor {

  /** {@inheritDoc} */
  @Override
  public void visit(TextFieldFioriElement textField, ElementAction action) {
    switch (action.getOperation()) {
      case CLICK:
        System.out.println("Perform Click on TextField " + textField.getText());
        break;
      case INPUT:
        System.out.println("Perform Input on TextField " + textField.getText());
        break;
      case DOUBLE_CLICK:
        System.out.println("Perform DoubleClick on TextField " + textField.getText());
        break;
    }
  }

  /** {@inheritDoc} */
  @Override
  public void visit(ButtonFioriElement button, ElementAction action) {
    System.out.println(action.getOperation() + " on " + button.getText() + " Button.");
  }
}
