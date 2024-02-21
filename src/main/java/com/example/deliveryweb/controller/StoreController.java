package com.example.deliveryweb.controller;

import com.example.deliveryweb.entity.Store;
import com.example.deliveryweb.repository.StoreRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class StoreController {

    private final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping("/stores")
    public String showStoresByCategory(@Valid Store store, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/";
        }
        String category = store.getCategory();
        List<Store> stores = storeRepository.findByCategory(category);
        model.addAttribute("stores", stores);
        return "storesList";
    }

    @GetMapping("/stores/{id}")
    public String getStoreDetail(@PathVariable Long id, Model model){
        Store store = storeRepository.findByIdWithMenus(id).orElse(null);

        if(store == null){
            return "error";
        }
        model.addAttribute(store);
        return "storeDetail";
    }
}
