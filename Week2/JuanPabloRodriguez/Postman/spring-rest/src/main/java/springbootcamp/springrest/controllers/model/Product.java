package springbootcamp.springrest.controllers.model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Product {

    @NotNull
    private String id;

    @NotNull
    private String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String id) {
        this.id = id;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
