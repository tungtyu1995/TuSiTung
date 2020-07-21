package java_collection_framework.baitap.quan_ly_san_pham;


public class Product {
    public int id;
    public String name;
    public double price;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double priceProduct) {
        this.id = idProduct;
        this.name = nameProduct;
        this.price = priceProduct;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "IdProduct: " + id + " NameProduct: " + name + " PriceProduct: " + price;
    }
}