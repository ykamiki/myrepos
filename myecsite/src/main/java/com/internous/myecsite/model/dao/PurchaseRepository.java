package com.internous.myecsite.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.internous.myecsite.model.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
	
	@Query(value="SELECT * FROM purchase p " + 
			"INNER JOIN product pro " + 
			"ON p.product_id = pro.id " + 
			"WHERE  created_at = (" + 
			"SELECT MAX(created_at) FROM purchase p WHERE p.user_id = :userId) ", nativeQuery = true)
	List<Purchase> findHistory(@Param("userId") long userId);

}
