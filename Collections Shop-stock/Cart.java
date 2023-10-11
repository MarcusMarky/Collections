public final class Cart extends ItemRepository{
    
    private Client owner;
    private Money<Currency> total;
    private ItemRepository stock;

    public Cart(Client owner, Currency currency, ItemRepository stock) {
        this.owner = owner;
        this.total = new Money<>(0, currency);
        this.stock = stock;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "\nCart owner: " + owner +"\nTotal: " +total + "\n\n"+ super.toString();
    }

    @Override
    public void addItem(Item<Product> item) {
        Item<Product> stockItem = stock.getItemById(item.getValue().getId());
    //HW5: 
        if (stockItem != null && stockItem.getQuantity() >= item.getQuantity()) {
            super.addItem(item);
            total.setAmount(total.getAmount() + calculateItemCostAsInt(item));
            stockItem.setQuantity(stockItem.getQuantity() - item.getQuantity());
        } else {
            System.out.println("The specified item is not available in the required quantity.");
        }
    }
    //HW3/6:
    @Override
public void removeItem(Item<Product> item) {
    Item<Product> stockItem = stock.getItemById(item.getValue().getId());
     
    if (stockItem != null) {
        super.removeItem(item);
        total.setAmount(total.getAmount() - calculateItemCostAsInt(item)); 
        stockItem.setQuantity(stockItem.getQuantity() + item.getQuantity()); 
    } else {
        System.out.println("The specified item is not available in the required quantity.");
    }
}

    private int calculateItemCostAsInt(Item<Product> item){
    
    return item.getValue().getPrice().getAmount() * item.getQuantity();
}

//HW2:
    public void removeItemById(Integer id) {
    Item<Product> itemToRemove = null;

    for (Item<Product> item : items) {
        if (item.getValue().getId().equals(id)) {
            itemToRemove = item;
            break;
        }
    }
    
    if (itemToRemove != null) {
        int itemValue = itemToRemove.getValue().getPrice().getAmount() * itemToRemove.getQuantity();
        updateTotal(-itemValue); 
        items.remove(itemToRemove);
    }
}

protected void updateTotal(int value) {
    total.setAmount(total.getAmount() + value);
}
//HW4: 
public void increaseItemQuantity(Item<Product> item, int quantityToAdd) {
    if (item != null) {
        int currentQuantity = item.getQuantity();
        int stockQuantity = getStockQuantity(item);

        if (stockQuantity >= quantityToAdd) {
            item.setQuantity(currentQuantity + quantityToAdd);
            total.setAmount(total.getAmount() + item.getValue().getPrice().getAmount() * quantityToAdd);
        } else {
            System.out.println("\n The stock does not have enough items available.");
        }
    } else {
        System.out.println("The specified item does not exist in the cart.");
    }
}


private int getStockQuantity(Item<Product> item) {
    Item<Product> stockItem = stock.getItemById(item.getValue().getId());

    if (stockItem != null) {
        return stockItem.getQuantity();
    } else {
        return 0; 
    }
}


public void decreaseItemQuantity(Item<Product> item, Integer amount) {
    if (amount > 0 && item.getQuantity() >= amount) {
        item.setQuantity(item.getQuantity() - amount);
        int valueChange = -item.getValue().getPrice().getAmount() * amount;
        updateTotal(valueChange);

        if (item.getQuantity() == 0) {
            removeItem(item);
        }
    }
  }
  public class InsufficientQuantityException extends Exception {
    public InsufficientQuantityException(String message) {
        super(message);
    }
}
}
