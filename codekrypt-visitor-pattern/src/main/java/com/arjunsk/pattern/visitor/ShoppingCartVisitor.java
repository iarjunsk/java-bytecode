package com.arjunsk.pattern.visitor;

import com.arjunsk.pattern.item.imp.BookShoppingItem;
import com.arjunsk.pattern.item.imp.FruitShoppingItem;

public interface ShoppingCartVisitor {

  int visit(BookShoppingItem book);

  int visit(FruitShoppingItem fruit);
}
