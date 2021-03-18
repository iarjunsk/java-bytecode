package com.arjunsk.pattern;

import com.arjunsk.pattern.core.element.FioriElement;
import com.arjunsk.pattern.core.element.imp.ButtonFioriElement;
import com.arjunsk.pattern.core.element.imp.TextFieldFioriElement;
import com.arjunsk.pattern.core.visitor.FioriElementVisitor;
import com.arjunsk.pattern.core.visitor.impl.ChromeFioriElementVisitorImpl;
import com.arjunsk.pattern.domain.ElementAction;
import com.arjunsk.pattern.domain.support.ElementOperation;

class FioriAutomationDriver {

  public static void main(String[] args) {

    FioriElement[] elements =
        new FioriElement[] {
          new TextFieldFioriElement("Username", "Areal"),
          new TextFieldFioriElement("Password", "Areal"),
          new ButtonFioriElement("Login", "Red")
        };

    clickElements(elements);
  }

  /**
   * Click all the elements.
   *
   * @param fioriElements List of fiori elements.
   */
  private static void clickElements(FioriElement[] fioriElements) {
    FioriElementVisitor visitor = new ChromeFioriElementVisitorImpl();
    ElementAction elementAction = new ElementAction(ElementOperation.CLICK);

    for (FioriElement fioriElement : fioriElements) {
      fioriElement.accept(visitor, elementAction);
    }
  }
}
