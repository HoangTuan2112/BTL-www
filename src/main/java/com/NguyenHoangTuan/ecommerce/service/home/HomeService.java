package com.NguyenHoangTuan.ecommerce.service.home;

import org.springframework.ui.Model;

import java.security.Principal;

 
public interface HomeService {

    void home(Model model);

    void cart(Principal principal, Model model);

    void searchProduct(String searchKeywords, Model model);

}
