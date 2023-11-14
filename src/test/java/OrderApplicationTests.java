import dto.OrderDTO;
import model.OrderModel;
import org.apache.catalina.mapper.Mapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.ExpectedCount;
import service.Impl.OrderServiceImpl;

import javax.swing.text.html.parser.Entity;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class OrderApplicationTests{

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderModel orderModel;


    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void verifySimilar() throws JSONException {
        JSONObject actual = new JSONObject()
                .put("price", 10.99)
                .put("quantity", 3)
                .put("item", "Product A");

        assertEquals("{price:10.99}", actual, false);
        assertEquals("{quantity:3}", actual, false);
        assertEquals("{item:\"testItem\", quantity:3}", actual, false);
        assertEquals("{price:10.99, quantity:3}", actual, false);
        assertEquals("{item:\"testItem\", price:10.99}", actual, false);

    }

    @Test
    void saveOrderTest() {

        OrderDTO orderDTO = new OrderDTO(123, 2, "testItem");

        orderService.saveOrder(orderDTO);

        Mockito.verify(orderService, times((1))).saveOrder(orderDTO);
    }

    @Test
    void findByItemTest() {

        when(orderModel.getItem()).thenReturn(String.valueOf(new OrderDTO(10.99, 3, "testItem")));

        OrderDTO dto = (OrderDTO) orderService.findOrderByItem("1");

        Assert.assertEquals(10.99, dto.getPrice());
        Assert.assertEquals(3, dto.getQuantity());
    }

}