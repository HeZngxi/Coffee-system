import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Order {
    private Vector<OrderItem> items=new Vector();
    public Order(){

    }
    public void addItem(OrderItem orderItem){

        this.items.add(orderItem);
    }
    public void removeItem(OrderItem orderItem){
        this.items.remove(orderItem);
    }
    public Iterator getItemsIterator(){
        return items.iterator();
    }
    public OrderItem getItem(Product product){
        for(OrderItem orderItem:items){
            if(orderItem.getProduct().equals(product))
                return orderItem;
        }
        return null;
    }
    public int getNumberOfItems(){
        return items.size();
    }
    public double getTotalCost(){
        double sum=0;
        for (int i = 0; i < items.size(); i++) {
            sum+=items.get(i).getValue();
        }
        return sum;
    }
}
