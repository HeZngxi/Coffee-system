import java.util.HashMap;
import java.util.Iterator;

public class XMLSalesFormatter implements SalesFormatter{

    private XMLSalesFormatter(){};
    static XMLSalesFormatter singletonInstance;
    static public XMLSalesFormatter getSingletonInstance(){
        if(singletonInstance==null)
            return new XMLSalesFormatter();
        return singletonInstance;
    }
    @Override
    public String formatSales(Sales sales) {
        String str="\n<Sales>'\n";
        Iterator itertor2=sales.getOrdersIterator();
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
            str=str+"  <Order total="+'"'+totalCost+'"'+">\n";
            for(HashMap.Entry<Product,Integer> entry:hashMap.entrySet()){
                int i=1;
                str=str+"<OrderItem quantity="+'"'+entry.getValue()+'"'+" price="+'"'+
                        entry.getKey().getPrice()+'"'+">"+entry.getKey().getCode()+"</OrderItem>\n"+
                        "  </Order>'\n";
                i++;
            }
        }
        str=str+"</Sales>";
        return str;
    }
}
