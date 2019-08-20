package com.internous.myecsite.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internous.myecsite.model.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long> {

}
