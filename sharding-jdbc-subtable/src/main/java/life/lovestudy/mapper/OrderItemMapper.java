package life.lovestudy.mapper;

import life.lovestudy.entity.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemMapper {

//	private long id;
//	private long orderId;
//	private long productId;
//	private int productSize;
	
	// 添加一个订单项
	@Insert("insert into t_order_item (orderId,productId,productSize) value(#{orderId},#{productId},#{productSize})")
	int addOrderItem(OrderItem orderItem);
	
	int addOrderItems(List<OrderItem> orderItems);
}
