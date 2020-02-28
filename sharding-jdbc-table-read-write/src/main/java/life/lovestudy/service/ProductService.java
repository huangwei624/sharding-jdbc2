package life.lovestudy.service;

import life.lovestudy.entity.Product;

import java.util.List;

public interface ProductService {
	// 添加一个商品
	int addProduct(Product product);
	
	// 添加多个商品
	int addProduct(List<Product> products);
	
	// 根据商品的id获取商品
	Product findProduct(long id);
	
	/**
	 * 减库存
	 * @param productId
	 * @param productSize
	 */
	void reduceStock(long productId, int productSize);
}
