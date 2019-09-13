package pl.javastart.zad1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.zad1.Category;
import pl.javastart.zad1.Product;
import pl.javastart.zad1.ProductsRepository;

import java.util.List;

@Controller
public class ProductControler {

    private ProductsRepository productsRepository;

    public ProductControler(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/lista")
    @ResponseBody
    public String showList (@RequestParam (required = false, name ="kategoria")String category){
        List<Product> products = productsRepository.getProducts();
        String result =  "<h2>Lista produktów</h2><table style=\"border: solid\"><tr><th>Nazwa</th><th>Cena</th><th>Kategoria</th></tr>";

        double sum = 0;

        for (Product product : products){
            if(category == null){
                result += "<tr>" + product.toString() + "</tr>";
                sum += product.getPrice();
            }
            else if (category.equalsIgnoreCase(product.getCategory().name())){
                result += "<tr>" + product.toString() + "</tr>";
                sum += product.getPrice();
            }

        }
        result += "<tr><td>Suma</td><td>" + sum + "</td><td></td></tr>";
        result += "</table><br/> <a href=\"index.html\">Powrot do strony glownej</a>";
        return result;
    }

    @PostMapping("/add")
    public String addProduct (@RequestParam String name, @RequestParam String price, @RequestParam String category){
        Product product = new Product(name, Double.valueOf(price), Category.valueOf(category));
        productsRepository.add(product);
        return ("redirect:/lista");
    }
}
