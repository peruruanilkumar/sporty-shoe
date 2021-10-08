package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.repository.ProductRepo;

@RestController
@RequestMapping("pro")
public class ProductController {

	@Autowired
	ProductRepo prorepo;

	@PostMapping("add")
	public Product addProduct(@RequestBody Product product)
	{
		return prorepo.save(product);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable int id)
	{
		prorepo.deleteById(id);
	}
	
	@GetMapping("all")
	public List<Product> getAllProduct()
	{
		List<Product> shoe=(List<Product>) prorepo.findAll(); 
		return shoe;
	}
	

	// update existing shoes 
	@PutMapping("update/{id}")
	public Product updateproduct(@RequestBody Product p)
	{
		return prorepo.save(p);
	}
	
	// get particular shoe by ID
	@GetMapping("shoe/{id}")
	public Optional<Product> getProductId(@PathVariable int id)
	{
		return prorepo.findById(id);
	}
	
	
	@GetMapping("shoep/{price}")
	public List<Product> getProprice(@PathVariable int price)
	{
		List<Product> pr= (List<Product>) prorepo.findByprice(price); 
		return pr;
	}
		
	// get particular shoe by season
	@GetMapping("shoes/{season}")
	public List<Product> getProId(@PathVariable String season)
	{
		List<Product> sea =(List<Product>) prorepo.findByseason(season);
		return sea;
	}
				
	// get particular shoe by brand
	@GetMapping("shoeb/{brand}")
	public List<Product> getShoebrand(@PathVariable String brand)
	{
		List<Product> br =(List<Product>) prorepo.findBybrand(brand);
		return br;
	}
		
	// by color
	@GetMapping("shoec/{color}")
	public List<Product> getShoecolor(@PathVariable String color)
	{
		List<Product> clr = (List<Product>) prorepo.findBycolor(color);
		return clr;
	}
				
   // by category
   @GetMapping("shoecat/{category}")
	public List<Product> getShoecategory(@PathVariable String category)
	{
		List<Product> cat = (List<Product>) prorepo.findBycategory(category);
		return cat;
	}
		
   //by date
   @GetMapping("sh/{createdDate}")
   public List<Product> getShoedate(@PathVariable String createdDate)
	{
	   List<Product> create = (List<Product>) prorepo.findBycreatedDate(createdDate);
	   return create;
	}
				
				
}

