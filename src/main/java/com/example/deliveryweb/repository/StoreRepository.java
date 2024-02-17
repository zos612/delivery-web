package com.example.deliveryweb.repository;

import com.example.deliveryweb.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findByCategory(String category);
}
