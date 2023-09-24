import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Product> items = new ArrayList<>();

        System.out.println("Initial items in the shopping cart: " + items.size());

        items.add(new Food("Pizza", 10.99, 500));
        items.add(new Food("Salad", 5.99, 300));
        items.add(new Food("Soup", 7.49, 400));
        items.add(new Drink("Cola", 2.99, 0.5));
        items.add(new Drink("Sprite", 3.49, 0.25));

        System.out.println("After adding some items: " + items.size()+ "\n");

        for (Product item : items) {
            System.out.println(item);
        }

        items.removeIf(item -> item.getName().equals("Pizza"));

        System.out.println("\nAfter removing Pizza: " + items.size()+" items remaince in the shopping cart");
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + getName() + ", Price: Lei " + getPrice();
    }
}

class Food extends Product {
    private int weightInGrams;

    public Food(String name, double price, int weightInGrams) {
        super(name, price);
        this.weightInGrams = weightInGrams;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    @Override
    public String toString() {
        return "Food: " + getName() + ", Price: Lei " + getPrice() + ", Weight: " + getWeightInGrams() + " grams";
    }
}

class Drink extends Product {
    private double volumeInLiters;

    public Drink(String name, double price, double volumeInLiters) {
        super(name, price);
        this.volumeInLiters = volumeInLiters;
    }

    public double getVolumeInLiters() {
        return volumeInLiters;
    }

    @Override
    public String toString() {
        return "Drink: " + getName() + ", Price: Lei " + getPrice() + ", Volume: " + getVolumeInLiters() + " liters";
    }
}