package com.NguyenHoangTuan.ecommerce.service.delivery;

import org.springframework.ui.Model;

import java.security.Principal;

 
public interface DeliveryService {

    String getPendingDeliveries(Model model, Principal principal);

    String searchPendingDelivery(String orderDetail, Principal principal, Model model);


}
