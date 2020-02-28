package life.lovestudy.mapper;

import life.lovestudy.entity.Product;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductMapper {
	
	/*private long id;
	private String productName;
	private BigDecimal price;
	private int stock;*/
	
	// 添加一个商品
	@Insert("insert into t_product(productName, price, stock) value(#{productName},#{price},#{stock})")
	int addProduct(Product product);
	
	// 添加多个商品
	int addProducts(List<Product> products);
	
	// 根据商品id获取商品
	@Select("select productName, price, stock from t_product where id=#{id}")
	Product findProduct(long id);
	
	/**
	 * 减库存
	 * @param productId
	 * @param currentStock
	 */
	@Update("update t_product p set p.stock = #{currentStock} where p.id=#{productId}")
	void reduceStock(@Param("productId") long productId, @Param("currentStock") int currentStock);
}
