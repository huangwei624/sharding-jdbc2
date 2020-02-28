package life.lovestudy.service.impl;

import life.lovestudy.entity.Product;
import life.lovestudy.mapper.ProductMapper;
import life.lovestudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public int addProduct(Product product) {
		return productMapper.addProduct(product);
	}
	
	@Override
	public int addProduct(List<Product> products) {
		return productMapper.addProducts(products);
	}
	
	@Override
	public Product findProduct(long id) {
		Product product = productMapper.findProduct(id);
		if (product == null) throw new RuntimeException("-------->>此商品不存在");
		return product;
	}
	
	/**
	 * 减库存
	 * @param productId
	 * @param productSize
	 */
	@Override
	public void reduceStock(long productId, int productSize) {
		int currentStock = productMapper.findProduct(productId).getStock()-productSize;
		productMapper.reduceStock(productId, currentStock);
	}
	
	
}
