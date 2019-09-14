package pl.javastart.zad.repository;

import org.springframework.stereotype.Repository;
import pl.javastart.zad.model.Category;
import pl.javastart.zad.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("ser", 2.5, Category.SPOZYWCZE));
        products.add(new Product("młotek", 12.5, Category.DOMOWE));
        products.add(new Product("komputer", 1200.5, Category.INNE));
    }

    public List<Product> getProducts(){
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }
}
