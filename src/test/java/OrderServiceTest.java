import checkoutservice.OrderService;
import checkoutservice.Product;
import checkoutservice.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    OrderService orderService;

    @Test
    void shouldCalculateTotalForProduct() {
        Product product = new Product(1, "Mjölk", 25.0);

        when(productRepository.findById(1))
                .thenReturn(product);

        double result = orderService.calculateTotal(1, 2);

        assertEquals(50.0, result);

        verify(productRepository).findById(1);
    }

    @Test
    void shouldThrowExceptionWhenProductDoesNotExist() {
        when(productRepository.findById(99))
                .thenReturn(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> orderService.calculateTotal(99, 2)
        );

        verify(productRepository).findById(99);
    }

    @Test
    void shouldThrowExceptionWhenQuantityIsZero() {
        Product product = new Product(1, "Mjölk", 25.0);

        when(productRepository.findById(1))
                .thenReturn(product);

        assertThrows(
                IllegalArgumentException.class,
                () -> orderService.calculateTotal(1, 0)
        );
    }



}
