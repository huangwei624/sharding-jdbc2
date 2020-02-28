package life.lovestudy.service;

import life.lovestudy.entity.Order;
import life.lovestudy.entity.OrderItem;

import java.util.List;

public interface OrderService {
	
	// 下单
	void createOrder(Order order);
	
	// 查订单详情
	List<OrderItem> findOrderItems(long orderId);
}
