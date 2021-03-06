package com.arjunsk.pattern.item.imp;

import com.arjunsk.pattern.item.ShoppingItem;
import com.arjunsk.pattern.visitor.ShoppingCartVisitor;

public class BookShoppingItem implements ShoppingItem {

  private final int price;
  private final String isbnNumber;

  public BookShoppingItem(int cost, String isbn) {
    this.price = cost;
    this.isbnNumber = isbn;
  }

  public int getPrice() {
    return price;
  }

  public String getIsbnNumber() {
    return isbnNumber;
  }

  @Override
  public int accept(ShoppingCartVisitor visitor) {
    return visitor.visit(this);
  }

}
