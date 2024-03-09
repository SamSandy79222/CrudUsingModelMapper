package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

public interface ProductService {

	public ProductDto createProduct(ProductDto productDto);
	public Optional<ProductDto> getProduct(long id);
	public List<ProductDto> getAllProduct();
	public String updateProduct(long id,ProductDto productDto);
	public String deleteProduct(long id);
}
