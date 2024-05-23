import java.util.HashMap;
import java.util.Iterator;

public class HTMLSalesFormatter implements SalesFormatter{
    private HTMLSalesFormatter(){};
    static HTMLSalesFormatter singletonInstance=new HTMLSalesFormatter();
    static public HTMLSalesFormatter getSingletonInstance(){
        if(singletonInstance == null){
            return new HTMLSalesFormatter();
        }
        return singletonInstance;
    }
    @Override
    public String formatSales(Sales sales) {
        String str="\n<html>\n" +
                "  <body>\n" +
                "    <center><h2>Orders</h2></center>\n";
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
            str=str+"<hr>\n" +
                    "    <h4>Total = "+totalCost+"</h4>\n";

            for(HashMap.Entry<Product,Integer> entry:hashMap.entrySet()){
                str=str+"<p>\n" +
                        "        <b>code:</b> "+entry.getKey().getCode()+"<br>\n" +
                        "        <b>quantity:</b> "+entry.getValue()+"<br>\n" +
                        "        <b>price:</b> "+entry.getKey().getPrice()+"\n" +
                        "     </p>\n";
            }
        }
        str=str+"  </body>\n" +
                "</html>\n";
        return str;
    }
}
