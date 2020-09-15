package com.faith.ecommerce.dao;

import com.faith.ecommerce.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
	
	//Search by Keyword -Based on Upper/Lowercases
	@Query(value="select * from Product p where p.name like BINARY concat('%', :name,'%')", nativeQuery = true)
	Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
	
	
}
