package checkoutservice;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final Map<Integer, Product> products = new HashMap<>();

    public InMemoryProductRepository() {
        products.put(1, new Product(1, "Mjölk", 25.0));
        products.put(2, new Product(2, "Bröd", 30));
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
