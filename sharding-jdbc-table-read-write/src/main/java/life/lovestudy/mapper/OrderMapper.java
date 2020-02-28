package life.lovestudy.mapper;

import life.lovestudy.entity.Order;
import life.lovestudy.entity.OrderItem;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface OrderMapper {

//	private long orderId;
//	private BigDecimal totalMoney;
	
	// 创建订单
	@Insert("insert into t_order(orderId, totalMoney) value (#{orderId}, #{totalMoney})")
	int addOrder(Order order);
	
	@Select("select m.productId, m.orderId, m.productSize from t_order_item m where m.orderId=#{orderId}")
	@Results({
		@Result(property = "product", column = "productId", one = @One(select = "life.lovestudy.mapper.ProductMapper.findProduct"))})
	List<OrderItem> findOrderItems(long orderId);
	
}
