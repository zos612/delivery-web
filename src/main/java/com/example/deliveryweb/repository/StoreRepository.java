package com.example.deliveryweb.repository;

import com.example.deliveryweb.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("select store from Store store left join fetch store.menus where store.id =:id")
    Optional<Store> findByIdWithMenus(long id);
    List<Store> findByCategory(String category);
}
