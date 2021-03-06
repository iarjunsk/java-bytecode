package com.arjunsk.pattern;

import com.arjunsk.pattern.item.ShoppingItem;
import com.arjunsk.pattern.item.imp.BookShoppingItem;
import com.arjunsk.pattern.item.imp.FruitShoppingItem;
import com.arjunsk.pattern.visitor.ShoppingCartVisitor;
import com.arjunsk.pattern.visitor.impl.GreensShoppingCartVisitorImpl;

/** Example reference: https://www.geeksforgeeks.org/visitor-design-pattern/ */
class ShoppingCartClient {

  public static void main(String[] args) {
    ShoppingItem[] items =
        new ShoppingItem[] {
          new BookShoppingItem(20, "1234"),
          new BookShoppingItem(100, "5678"),
          new FruitShoppingItem(10, 2, "Banana"),
          new FruitShoppingItem(5, 5, "Apple")
        };

    int total = calculatePrice(items);
    System.out.println("Total Cost = " + total);
  }

  private static int calculatePrice(ShoppingItem[] items) {
    ShoppingCartVisitor visitor = new GreensShoppingCartVisitorImpl();
    int sum = 0;
    for (ShoppingItem item : items) {
      sum = sum + item.accept(visitor);
    }
    return sum;
  }
}
