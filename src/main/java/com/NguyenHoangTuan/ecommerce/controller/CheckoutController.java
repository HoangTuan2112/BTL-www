package com.NguyenHoangTuan.ecommerce.controller;

import com.NguyenHoangTuan.ecommerce.model.entity.User;
import com.NguyenHoangTuan.ecommerce.service.checkout.CheckoutService;
import com.NguyenHoangTuan.ecommerce.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CheckoutController {

//    private final CheckoutService checkoutService;
    private final UserService userService;

    @ModelAttribute
    public String checkLoginStatus(
            Principal principal,
            Model model
    ) {
        if (principal == null) {
            model.addAttribute("isUserLoggedIn", null);
            return "redirect:/login";
        } else {
            User user = this.userService.getUserByEmail(principal.getName());
            model.addAttribute("isUserLoggedIn", user);
            model.addAttribute("loggedInUserRole", user.getRole());

            return "redirect:/process-checkout";
        }
    }

//    @RequestMapping("/checkout")
//    public String checkout(
//            Principal principal,
//            Model model
//    ) {
//        return this.checkoutService.checkout(principal, model);
//    }

//    @RequestMapping(value = "/order-confirmed/{orderId}", method = RequestMethod.GET)
//    public String orderConfirmed(
//            @PathVariable("orderId") String orderId,
//            Model model,
//            Principal principal
//    ) {
//        return this.checkoutService.confirmOrder(orderId, model, principal);
//    }

    @RequestMapping(value = "/checkout/isUserLoggedIn", method = RequestMethod.GET)
    public ResponseEntity<Boolean> isUserLoggedIn(Principal principal) {
        return ResponseEntity.ok(principal != null);
    }

}