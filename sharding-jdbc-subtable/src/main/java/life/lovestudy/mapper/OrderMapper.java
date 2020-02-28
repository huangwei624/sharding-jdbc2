package life.lovestudy.mapper;

import life.lovestudy.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface OrderMapper {

//	private long orderId;
//	private BigDecimal totalMoney;
	
	// 创建订单
	@Insert("insert into t_order(orderId, totalMoney) value (#{orderId}, #{totalMoney})")
	int addOrder(Order order);
	
}
