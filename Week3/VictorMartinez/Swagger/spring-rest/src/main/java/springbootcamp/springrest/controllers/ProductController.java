package springbootcamp.springrest.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import springbootcamp.springrest.controllers.model.Product;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Api(value = "Swagger2DemoController")
@RestController()
@RequestMapping(value="/products", produces = "application/json")
public class ProductController {

    private final List<Product> products = new CopyOnWriteArrayList<>(asList(new Product("P435", "Product_1"), new Product("P552", "Product_2")));

    @ApiOperation(value = "Get list of products in the System ", response = Iterable.class, tags = "getAllProducts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!!!"),
            @ApiResponse(code = 404, message = "Not found!!!") })
    @GetMapping
    public List<Product> getAll(){
        return products;
    }


    @ApiOperation(value = "Get specific Product in the System ", response = Product.class, tags = "getProduct")
    @GetMapping("/{id}")
    public Product  get(@PathVariable("id") @NotNull  String id){
        return getProduct(id);
    }

    @ApiOperation(value = "Get specific Product By Name in the System ", response = Product.class, tags = "getProductByName")
    @GetMapping("/filter")
    public List<Product> filter(@RequestParam("name") @NotNull String name){
        return products.stream()
                .filter(i -> name.equals(i.getName()))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Save new Product in the System ", response = void.class, tags = "saveNewProduct")
    @PostMapping
    public void save(@RequestBody @Valid Product product){
        products.add(product);
    }


    @ApiOperation(value = "Update specific Product By Id in the System ", response = void.class, tags = "updateProductById")
    @PutMapping("/{id}")
    public void update(@PathVariable("id") @NotNull  String id, @RequestBody @Valid Product product){
        getProduct(id).setName(product.getName());
    }

    @ApiOperation(value = "Get specific Product By Id in the System ", response = Product.class, tags = "getProductById")
    private Product getProduct(String id) {
        return products.stream()
                .filter(i -> id.equals(i.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    @ApiOperation(value = "Delete specific Product By id from the System ", response = Product.class, tags = "deleteProductById")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") @NotNull  String id){
        products.remove(new Product(id));
    }



}
