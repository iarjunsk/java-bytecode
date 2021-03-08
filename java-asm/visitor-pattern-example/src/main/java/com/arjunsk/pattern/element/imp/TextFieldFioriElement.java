package com.arjunsk.pattern.element.imp;

import com.arjunsk.pattern.domain.ElementAction;
import com.arjunsk.pattern.element.FioriElement;
import com.arjunsk.pattern.visitor.FioriElementVisitor;

public class TextFieldFioriElement implements FioriElement {

  private final String text;
  private final String font;

  public TextFieldFioriElement(String text, String font) {
    this.text = text;
    this.font = font;
  }

  public String getText() {
    return text;
  }

  public String getFont() {
    return font;
  }

  @Override
  public void accept(FioriElementVisitor visitor, ElementAction action) {
    visitor.visit(this, action);
  }
}
