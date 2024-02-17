package com.example.deliveryweb;

import com.example.deliveryweb.entity.Store;
import com.example.deliveryweb.repository.StoreRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

    final StoreRepository storeRepository;

    public HomeController(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @GetMapping("/stores")
    public String store(@Valid Store store, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/";
        }
        String category = store.getCategory();
        List<Store> stores = storeRepository.findByCategory(category);
        model.addAttribute("stores", stores);
        return "stores";
    }
}
