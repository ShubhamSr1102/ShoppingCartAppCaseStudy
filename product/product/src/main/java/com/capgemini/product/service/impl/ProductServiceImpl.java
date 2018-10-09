package com.capgemini.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.product.entity.Product;
import com.capgemini.product.exception.ProductNotFoundException;
import com.capgemini.product.repository.ProductRepository;
import com.capgemini.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(int productId) throws ProductNotFoundException {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isPresent())
			return optionalProduct.get();
		throw new ProductNotFoundException("Product does not exists");
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

	@Override
	public List<Product> findByProductName(String productName) throws ProductNotFoundException {
		List<Product> productList = productRepository.findByProductName(productName);
		if (!productList.isEmpty()) {
			return productList;
		}
		throw new ProductNotFoundException("Product does not exists");
	}

	@Override
	public List<Product> findByProductCategory(String productCategory) throws ProductNotFoundException {
		List<Product> productList = productRepository.findByProductCategory(productCategory);
		if (!productList.isEmpty()) {
			return productList;
		}
		throw new ProductNotFoundException("Product does not exists");
	}

	@Override
	public List<Product> findByProductByRange(String productCategory, double min, double max)
			throws ProductNotFoundException {
		List<Product> productList = productRepository.findByProductByRange(productCategory, min, max);
		System.out.println(productList);
		if (!productList.isEmpty()) {
			return productList;
		}
		throw new ProductNotFoundException("Product does not exists");
	}
}
