package life.lovestudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

// 商品类
@Alias("Product")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
	
	private long id;
	private String productName;
	private BigDecimal price;
	private int stock;
	
	public Product(String productName, BigDecimal price, int stock) {
		this.productName = productName;
		this.price = price;
		this.stock = stock;
	}
}
