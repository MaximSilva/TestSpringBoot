package service;

import dto.OrderDTO;
import model.OrderModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderDTO saveOrder(OrderDTO orderDTO);
    List<OrderDTO> findOrderByItem(String orderItem);
    OrderDTO deleteOrder(OrderDTO orderDTO);
}
