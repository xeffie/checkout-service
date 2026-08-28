public class OrderService {

    private final ProductRepository productRepository;

    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public double calculateTotal(int productId, int quantity) {
        Product product = productRepository.findById(productId);
        return product.getPrice() * quantity;
    }

}
