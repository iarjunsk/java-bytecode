package com.arjunsk.asm.reader.model;

public class RadioButton {

  private final String text;
  private final boolean isClickable;

  public RadioButton(String text, boolean isClickable) {
    this.text = text;
    this.isClickable = isClickable;
  }

  public String getText() {
    return text;
  }

  public boolean isClickable() {
    return isClickable;
  }
}
