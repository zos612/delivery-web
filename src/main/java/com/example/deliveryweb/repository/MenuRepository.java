package com.example.deliveryweb.repository;

import com.example.deliveryweb.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByStoreId(long storeId);
}
