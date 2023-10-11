import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Stock stock = new Stock();
        Product product = (new Product(1, "Samsung XC310", new Money<>(1000, Currency.EUR)));
        System.out.println("Stock Items: \n");
        
        stock.addItem(new Item<>(product, 10));
        
        System.out.println(stock.getItemById(1));
        
        Cart cart = new Cart(new Client("Nick Walter", "01203142"), Currency.EUR, stock);
        
        cart.addItem(new Item<>(product, 1));

        System.out.println("\n"+cart);
        
    
    }
}