import java.util.Objects;

public class Product {
    private String code;
    private String description;
    private double price;

    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return code+'_'+description+'_'+price;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Product) && (code.equals(((Product) o).getCode()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description, price);
    }
}
