import java.util.ArrayList;
import java.util.List;

public abstract class ItemRepository {
   
    protected List<Item<Product>> items;

    public ItemRepository () {
        items= new ArrayList<>();

    }
    
    public void addItem (Item<Product> item){
         items.add(item);
    }

    public void removeItem (Item<Product> item){
        items.remove(item);
    }
    
    @Override
    public String toString() {
        return "Item: " + items;
    }
    
    public Item<Product> getItemById(Integer id){
        Item<Product> item = null;
        
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getValue().getId() == id){
                item = items.get(i);
                break;
            }
        }
        return item;

    }
    
}
