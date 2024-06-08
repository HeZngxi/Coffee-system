public class OrderItem {
    private Product product;
    private int quantity;
    public OrderItem(Product product,int quantity){
        this.product=product;
        this.quantity=quantity;
    }
    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int newquantity){
        this.quantity=newquantity;
    }
    public double getValue(){
        return quantity*product.getPrice();
    }
    public String toString(){
        return quantity+" "+product.getCode()+" "+product.getPrice();

    }
}
