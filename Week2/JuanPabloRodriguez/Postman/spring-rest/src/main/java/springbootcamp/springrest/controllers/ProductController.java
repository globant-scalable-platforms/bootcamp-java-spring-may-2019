package springbootcamp.springrest.controllers;

import org.springframework.web.bind.annotation.*;
import springbootcamp.springrest.controllers.model.Product;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@RestController()
@RequestMapping("/products")
public class ProductController {

    private final List<Product> products = new CopyOnWriteArrayList<>(asList(new Product("P435", "Product 1"), new Product("P552", "Product 2")));

    @GetMapping
    public List<Product> getAll(){
        return products;
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") @NotNull  String id){
        return getProduct(id);
    }

    @GetMapping("/filter")
    public List<Product> filter(@RequestParam("name") @NotNull String name){
        return products.stream()
                .filter(i -> name.equals(i.getName()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void save(@RequestBody @Valid Product product){
        products.add(product);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") @NotNull  String id, @RequestBody @Valid Product product){
        getProduct(id).setName(product.getName());
    }

    private Product getProduct(String id) {
        return products.stream()
                .filter(i -> id.equals(i.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") @NotNull  String id){
        products.remove(new Product(id));
    }



}
