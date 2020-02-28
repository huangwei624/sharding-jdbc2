package life.lovestudy.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import life.lovestudy.entity.Order;
import life.lovestudy.entity.OrderItem;
import life.lovestudy.entity.Product;
import life.lovestudy.mapper.OrderItemMapper;
import life.lovestudy.mapper.OrderMapper;
import life.lovestudy.service.OrderService;
import life.lovestudy.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class MainController {
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private OrderService orderService;
	
	// 使用Jmeter模拟并发下单, 压测
	@GetMapping("createOrders")
	public String createOrders(){
		long orderId = System.currentTimeMillis() + new Random().nextInt(100);
		long productId1 = new Random().nextInt(10) + 21;    // 商品id
		long productId2 = new Random().nextInt(10) + 21;
		int productSize1 = new Random().nextInt(20);    // 购买数量
		int productSize2 = new Random().nextInt(20);
		OrderItem orderItem1 = new OrderItem(orderId, productId1, productSize1);
		OrderItem orderItem2 = new OrderItem(orderId, productId2, productSize2);
		Product product1 = ps.findProduct(productId1);
		Product product2 = ps.findProduct(productId2);
		
		log.info("------>> 购买的商品是："+product1.getProductName()+", 数量是："+productSize1);
		log.info("------>> 购买的商品是："+product2.getProductName()+", 数量是："+productSize2);
		BigDecimal totalMoney = new BigDecimal(0).add(new BigDecimal(productSize1).multiply(product1.getPrice()))
				                        .add(new BigDecimal(productSize2).multiply(product2.getPrice()));
		Order order = new Order(orderId, totalMoney, Arrays.asList(orderItem1, orderItem2));
		orderService.createOrder(order);
		return "success";
	}
	
	@GetMapping("createOrder")
	public String createOrder(){
		long orderId = 282;
		OrderItem orderItem1 = new OrderItem(orderId, 24, 15);
		OrderItem orderItem2 = new OrderItem(orderId, 27, 35);
		Product product1 = ps.findProduct(24);
		Product product2 = ps.findProduct(27);
		BigDecimal totalMoney = new BigDecimal(0).add(new BigDecimal(15).multiply(product1.getPrice()))
				                        .add(new BigDecimal(25).multiply(product2.getPrice()));
		Order order = new Order(orderId, totalMoney, Arrays.asList(orderItem1, orderItem2));
		orderService.createOrder(order);
		return "success";
	}
	
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@GetMapping("createSimpleOrder")
	public String createSimpleOrder(){
		orderItemMapper.addOrderItem(new OrderItem(22, 24, 12));
		return "success";
	}
	
	@GetMapping("insert")
	@SuppressWarnings("unchecked")
	public String addProducts(){
		Product product1 = new Product("香蕉", new BigDecimal(5.3), 100);
		Product product2 = new Product("苹果", new BigDecimal(7.0), 100);
		Product product3 = new Product("菠萝", new BigDecimal(2), 100);
		Product product4 = new Product("橘子", new BigDecimal(5), 100);
		Product product5 = new Product("火龙果", new BigDecimal(7.8), 100);
		Product product6 = new Product("西瓜", new BigDecimal(3.6), 100);
		Product product7 = new Product("杏子", new BigDecimal(5.9), 100);
		Product product8 = new Product("草莓", new BigDecimal(12), 100);
		Product product9 = new Product("芒果", new BigDecimal(2.5), 100);
		Product product10 = new Product("猕猴桃", new BigDecimal(6.3), 100);
		ArrayList<Product> products = new ArrayList(){
			{add(product1);add(product2);add(product3);add(product4);add(product5);
			add(product6);add(product7);add(product8);add(product9);add(product10);};
		};
		return ps.addProduct(products) > 0 ? "success" : "fail";
	}
	
	@Autowired
	private OrderMapper orderMapper;
	
	@GetMapping("getOrderItems")
	public List<OrderItem> getOrderItems(long orderId){
		return orderMapper.findOrderItems(orderId);
	}
	
}
