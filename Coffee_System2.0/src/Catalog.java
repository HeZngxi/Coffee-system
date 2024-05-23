import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Catalog {
    private Vector<Product> products = new Vector<>();
    public Catalog(){

    }
    public void addProduct(Product product){
        this.products.add(product);
    }
    public Iterator getProductsIterator(){
        return products.iterator();
    }
    public Product getProduct(String code){
        for(Product product:products){
            if(product.getCode().equals(code))
                return product;
        }
        System.out.println("Can't Found");
        return null;
    }
    public int getNumberOfProducts(){
        return products.size();
    }
}
