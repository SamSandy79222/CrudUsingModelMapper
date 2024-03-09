package com.example.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

@Configuration
public class ProductMapper {

	
	@Autowired
	public Mapper mapper;
	
	public Product toEntity(ProductDto productDto) {
		return mapper.modelMapper().map(productDto, Product.class);
	}
	
	public ProductDto toDto(Product product) {
		return mapper.modelMapper().map(product, ProductDto.class);
	}
	
}
