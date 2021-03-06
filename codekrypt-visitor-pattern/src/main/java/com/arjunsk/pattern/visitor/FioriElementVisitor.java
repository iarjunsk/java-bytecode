package com.arjunsk.pattern.visitor;

import com.arjunsk.pattern.domain.ElementAction;
import com.arjunsk.pattern.element.imp.ButtonFioriElement;
import com.arjunsk.pattern.element.imp.TextFieldFioriElement;

public interface FioriElementVisitor {

  /**
   * Action Logic for TextField Fiori Element in Chrome Browser.
   *
   * @param textField FioriElement.
   * @param action Action to be performed on FioriElement.
   */
  void visit(TextFieldFioriElement textField, ElementAction action);

  /**
   * Action Logic for Button Fiori Element in Chrome Browser.
   *
   * @param button FioriElement.
   * @param action Action to be performed on FioriElement.
   */
  void visit(ButtonFioriElement button, ElementAction action);
}
