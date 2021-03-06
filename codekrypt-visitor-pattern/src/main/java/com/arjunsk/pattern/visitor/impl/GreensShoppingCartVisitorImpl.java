package com.arjunsk.pattern.visitor.impl;

import com.arjunsk.pattern.item.imp.BookShoppingItem;
import com.arjunsk.pattern.item.imp.FruitShoppingItem;
import com.arjunsk.pattern.visitor.ShoppingCartVisitor;

/** Separate's Business Logic from Domain Class. */
public class GreensShoppingCartVisitorImpl implements ShoppingCartVisitor {

  @Override
  public int visit(BookShoppingItem book) {
    int cost = 0;
    // apply 5$ discount if book price is greater than 50
    if (book.getPrice() > 50) {
      cost = book.getPrice() - 5;
    } else cost = book.getPrice();

    System.out.println("Book ISBN::" + book.getIsbnNumber() + " cost =" + cost);
    return cost;
  }

  @Override
  public int visit(FruitShoppingItem fruit) {
    int cost = fruit.getPricePerKg() * fruit.getWeight();
    System.out.println(fruit.getName() + " cost = " + cost);
    return cost;
  }
}
