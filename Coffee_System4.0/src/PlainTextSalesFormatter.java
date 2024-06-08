import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PlainTextSalesFormatter implements SalesFormatter{

    private PlainTextSalesFormatter(){};
    static PlainTextSalesFormatter singletonInstance;
    static public PlainTextSalesFormatter getSingletonInstance(){
        if(singletonInstance==null)
            return new PlainTextSalesFormatter();
        return singletonInstance;
    }
    @Override
    public String formatSales(Sales sales) {
        String str="";
        Iterator itertor2=sales.getOrdersIterator();
        int number=1;
        while (itertor2.hasNext()){
            HashMap<Product,Integer> hashMap=new HashMap<>();
            Order order= (Order) itertor2.next();
            Iterator itertor=order.getItemsIterator();
            double totalCost=0;
            while (itertor.hasNext()){
                OrderItem orderItem= (OrderItem) itertor.next();
                totalCost+= orderItem.getValue();
                if(hashMap.containsKey(orderItem.getProduct())){
                    int quantity=hashMap.get(orderItem.getProduct());
                    hashMap.put(orderItem.getProduct(),quantity+ orderItem.getQuantity());
                }else{
                    hashMap.put(orderItem.getProduct(),orderItem.getQuantity());
                }
            }
            str=str+"Order "+number+'\n';
            int i=1;
            for(HashMap.Entry<Product,Integer> entry:hashMap.entrySet()){
                str=str+"quantity"+i+":"+entry.getValue()+" code"+i+":"+entry.getKey().getCode()+" price"+i+":"+entry.getKey().getPrice()+'\n';
                i++;
            }
            str=str+"Total = "+totalCost+'\n'+'\n';
            number++;
        }
        return str;
    }
}
