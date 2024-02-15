package com.example.deliveryweb;

import com.example.deliveryweb.entity.Store;
import com.example.deliveryweb.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String store(Model model){
        List<Store> stores = storeRepository.findAll();
        model.addAttribute("stores", stores);
        return "stores";
    }
}
