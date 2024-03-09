package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.ProductDto;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public ProductDto createProduct(ProductDto productDto) {
		Product entity = productMapper.toEntity(productDto);
		Product save = productRepository.save(entity);
		
		
		return productMapper.toDto(save);
	}

	@Override
	public Optional<ProductDto> getProduct(long id) {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findById(id);
			Optional<ProductDto> productdto = product.map((pr)->productMapper.toDto(pr));
		return productdto;
	}

	@Override
	public List<ProductDto> getAllProduct() {
		// TODO Auto-generated method stub
		
		List<Product> allproduct = productRepository.findAll();
		
		List<ProductDto> productdtolist = allproduct.stream().map((pr)-> productMapper.toDto(pr)).collect(Collectors.toList());
		return productdtolist;
	}

	@PutMapping("/update/{id}")
	@Override
	public String updateProduct(@PathVariable long id,@RequestBody ProductDto productDto){
		
		Product product=productMapper.toEntity(productDto);
		product.setId(id);
		productRepository.save(product);
		return "product updated succesfully with id "+id;
	}

	@Override
	public String deleteProduct(long id) {
		// TODO Auto-generated method stub
		
		if (productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
			return "succesfully deleted the product with id "+id;
		}
		return "no product exist with id "+id;
	}


}
