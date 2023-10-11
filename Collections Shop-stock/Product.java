public class Product {
    private Integer id;
    private String name;
    private Money<Currency> price;

    public Product(Integer id, String name, Money<Currency> price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Money<Currency> getPrice() {
        return price;
    }
    public void setPrice(Money<Currency> price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product name: " + name + " Id: " +id + " Price: " + price ;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

}
