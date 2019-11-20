package com.accenture.dao;

import java.util.List;
import com.accenture.entity.Product;

public interface ProductDao {
	public List<Product> getAll(); 
	public boolean create(Product s); 
	public Product getById(String i); 
	public boolean deleteById(String i);
	public boolean update(Product product); 
	public List<Product> search(String s);
}
