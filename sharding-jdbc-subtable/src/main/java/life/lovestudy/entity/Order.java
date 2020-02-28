package life.lovestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.List;

@Alias("Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	private long orderId;
	private BigDecimal totalMoney;
	
	// 订单项
	List<OrderItem> orderItems;
	
}
