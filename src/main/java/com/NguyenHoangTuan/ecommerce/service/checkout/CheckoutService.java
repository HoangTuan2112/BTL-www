package com.NguyenHoangTuan.ecommerce.service.checkout;

import org.springframework.ui.Model;

import java.security.Principal;

 
public interface CheckoutService {

    String checkout(Principal principal, Model model);

    String confirmOrder(String orderId, Model model, Principal principal);

}
