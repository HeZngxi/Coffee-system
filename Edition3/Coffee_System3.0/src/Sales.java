import java.util.Iterator;
import java.util.Vector;

public class Sales {
    private Vector<Order> orders=new Vector<>();
    public Sales(){
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public Iterator getOrdersIterator(){
        return this.orders.iterator();
    }
    public int getNumberOfOrders(){
        return orders.size();
    }
}
