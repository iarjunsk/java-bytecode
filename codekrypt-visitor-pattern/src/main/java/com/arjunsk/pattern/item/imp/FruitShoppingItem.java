package com.arjunsk.pattern.item.imp;

import com.arjunsk.pattern.item.ShoppingItem;
import com.arjunsk.pattern.visitor.ShoppingCartVisitor;

public class FruitShoppingItem implements ShoppingItem {

  private final int pricePerKg;
  private final int weight;
  private final String name;

  public FruitShoppingItem(int priceKg, int wt, String nm) {
    this.pricePerKg = priceKg;
    this.weight = wt;
    this.name = nm;
  }

  public int getPricePerKg() {
    return pricePerKg;
  }

  public int getWeight() {
    return weight;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public int accept(ShoppingCartVisitor visitor) {
    return visitor.visit(this);
  }
}
