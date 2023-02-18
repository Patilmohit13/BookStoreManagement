package com.bookmgm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmgm.entity.bookstore;

@Repository
public interface bookRepository extends JpaRepository<bookstore, Integer> {
	List<bookstore> findByName(String name);
	
}