package com.arjunsk.pattern.core.visitor;

import com.arjunsk.pattern.core.element.imp.ButtonFioriElement;
import com.arjunsk.pattern.core.element.imp.TextFieldFioriElement;
import com.arjunsk.pattern.domain.ElementAction;

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
