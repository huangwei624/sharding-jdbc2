package life.lovestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("OrderItem")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	
	private long id;
	private long orderId;
	private long productId;
	private int productSize;
	private Product product;
	
	public OrderItem(long orderId, long productId, int productSize) {
		this.orderId = orderId;
		this.productId = productId;
		this.productSize = productSize;
	}
}
