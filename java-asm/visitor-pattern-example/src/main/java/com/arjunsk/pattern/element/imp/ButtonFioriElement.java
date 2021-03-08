package com.arjunsk.pattern.element.imp;

import com.arjunsk.pattern.domain.ElementAction;
import com.arjunsk.pattern.element.FioriElement;
import com.arjunsk.pattern.visitor.FioriElementVisitor;

public class ButtonFioriElement implements FioriElement {

  private final String text;
  private final String color;

  public ButtonFioriElement(String text, String color) {
    this.text = text;
    this.color = color;
  }

  public String getText() {
    return text;
  }

  public String getColor() {
    return color;
  }

  @Override
  public void accept(FioriElementVisitor visitor, ElementAction action) {
    visitor.visit(this, action);
  }
}
