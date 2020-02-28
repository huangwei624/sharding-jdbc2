package life.lovestudy.service.impl;

import life.lovestudy.entity.Order;
import life.lovestudy.entity.OrderItem;
import life.lovestudy.entity.Product;
import life.lovestudy.mapper.OrderItemMapper;
import life.lovestudy.mapper.OrderMapper;
import life.lovestudy.service.OrderService;
import life.lovestudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@Autowired
	private ProductService productService;
	
	@Override
	@Transactional
	public void createOrder(Order order) {
		
		List<OrderItem> orderItems = order.getOrderItems();
		for (OrderItem o : orderItems) {
			Product product = productService.findProduct(o.getProductId());
			// 减库存，如果库存当前购买商品的数量，可以减，否则抛出异常
			if (product.getStock() < o.getProductSize())
				throw new RuntimeException(product.getProductName() + "库存不足！请重新下单！");
			productService.reduceStock(o.getProductId(), o.getProductSize());
			// 保存订单项记录
			orderItemMapper.addOrderItem(o);
		}
		// 保存订单记录
		orderMapper.addOrder(order);
	}
	
	@Override
	public List<OrderItem> findOrderItems(long orderId) {
		return orderMapper.findOrderItems(orderId);
	}
}
