package com.arjunsk.pattern.core.element.imp;

import com.arjunsk.pattern.core.element.FioriElement;
import com.arjunsk.pattern.core.visitor.FioriElementVisitor;
import com.arjunsk.pattern.domain.ElementAction;

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

  @Override
  public String getId() {
    return "Button";
  }
}
