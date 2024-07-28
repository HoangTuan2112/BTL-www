package com.NguyenHoangTuan.ecommerce.service.order;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.security.Principal;

 
public interface OrderService {

    String getDeliveredOrders(Principal principal, Model model);

    String searchDeliveredOrders(String orderDetail, Principal principal, Model model);

    String cancelOrder(String orderId, Model model, Principal principal, HttpSession session);

    String updateOrderStatus(String orderId, Model model, Principal principal, HttpSession session);

}
