package checkoutservice;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ProductRepository productRepository;

    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public double calculateTotal(int productId, int quantity) {
        Product product = productRepository.findById(productId);

        if (product == null) {
            throw new IllegalArgumentException("Produkten finns ej.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Antal måste vara fler än 0.");
        }

        return product.getPrice() * quantity;
    }

}
