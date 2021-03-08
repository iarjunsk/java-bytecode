package com.arjunsk.pattern;

import com.arjunsk.pattern.domain.ElementAction;
import com.arjunsk.pattern.element.FioriElement;
import com.arjunsk.pattern.element.imp.ButtonFioriElement;
import com.arjunsk.pattern.element.imp.TextFieldFioriElement;
import com.arjunsk.pattern.enums.ElementOperation;
import com.arjunsk.pattern.visitor.FioriElementVisitor;
import com.arjunsk.pattern.visitor.impl.ChromeFioriElementVisitorImpl;

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
    for (FioriElement fioriElement : fioriElements) {
      fioriElement.accept(visitor, new ElementAction(ElementOperation.CLICK));
    }
  }
}
