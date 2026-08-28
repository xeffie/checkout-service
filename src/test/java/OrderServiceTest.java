import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Product product = new Product(1, "Mjölk", 26.0);

        when(productRepository.findById(1))
                .thenReturn(product);

        double result = orderService.calculateTotal(1, 2);

        assertEquals(50.0, result);

        verify(productRepository).findById(1);
    }
}
