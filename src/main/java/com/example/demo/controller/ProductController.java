package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	
	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
	return new ResponseEntity<ProductDto>(productService.createProduct(productDto),HttpStatus.OK);
	}
	
	
	@GetMapping("/getproduct/{id}")
	public ResponseEntity<Optional<ProductDto>> getById(@PathVariable long id) {
		return new ResponseEntity<Optional<ProductDto>>(productService.getProduct(id),HttpStatus.OK);
		
	}
//
	@GetMapping("/getall")
	public ResponseEntity<List<ProductDto>> getAllProduct(){
		return new ResponseEntity<List<ProductDto>>(productService.getAllProduct(),HttpStatus.OK);
	}
//	
		@PutMapping("/update/{id}")
		public ResponseEntity<?> updateProduct(@PathVariable long id,@RequestBody ProductDto productDto){
			return new ResponseEntity<String>(productService.updateProduct(id, productDto),HttpStatus.OK);
		}
//	
//	
@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteProduct(@PathVariable long id){
	return new ResponseEntity<String>(productService.deleteProduct(id),HttpStatus.OK);
}
	
}
