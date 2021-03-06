package com.arjunsk.pattern.item;

import com.arjunsk.pattern.visitor.ShoppingCartVisitor;

public interface ShoppingItem {

  int accept(ShoppingCartVisitor visitor);
}
