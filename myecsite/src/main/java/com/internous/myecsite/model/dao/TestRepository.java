package com.internous.myecsite.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internous.myecsite.model.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}
