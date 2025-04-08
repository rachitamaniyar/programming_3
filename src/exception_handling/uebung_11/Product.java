package exception_handling.uebung_11;

public class Product {

    public String ProductName;
    public Double Price;
    public String ProductCategory;

    public Product(String productName, Double price, String productCategory) {

        ProductName = productName;
        Price = price;
        ProductCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductName='" + ProductName + '\'' +
                ", Price=" + Price +
                ", ProductCategory='" + ProductCategory + '\'' +
                '}';
    }
}
