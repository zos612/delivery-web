package com.example.deliveryweb;

import com.example.deliveryweb.entity.Menu;
import com.example.deliveryweb.entity.Store;
import com.example.deliveryweb.repository.MenuRepository;
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
public class HomeController {

    final StoreRepository storeRepository;
    final MenuRepository menuRepository;

    public HomeController(StoreRepository storeRepository, MenuRepository menuRepository) {
        this.storeRepository = storeRepository;
        this.menuRepository = menuRepository;
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
    public String showStoreDetail(@PathVariable Long id, Model model){
        List<Menu> menus = menuRepository.findByStoreId(id);
        model.addAttribute("menus", menus);
        return "storeDetail";
    }
}
