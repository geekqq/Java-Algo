package Day264;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Product {
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "HP Laptop", 25000));
        productList.add(new Product(2, "DELL Laptop", 30000));
        productList.add(new Product(3, "Lenovo Laptop", 28000));
        productList.add(new Product(4, "Sony Laptop", 23000));
        productList.add(new Product(5, "Apple Laptop", 90000));
        productList.stream().filter(p -> p.getPrice() > 25000)
                .map(Product::getName)
                .forEach(System.out::println);

        System.out.println();
        for (Product p : productList) {
            System.out.println(p.getPrice());
        }
    }
}
