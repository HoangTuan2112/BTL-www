package com.NguyenHoangTuan.ecommerce.controller;

import com.NguyenHoangTuan.ecommerce.model.entity.Category;
import com.NguyenHoangTuan.ecommerce.model.entity.User;
import com.NguyenHoangTuan.ecommerce.service.category.CategoryService;
import com.NguyenHoangTuan.ecommerce.service.product.ProductService;
import com.NguyenHoangTuan.ecommerce.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserService userService;

    @ModelAttribute
    public void checkLoginStatus(
            final Principal principal,
            final Model model
    ) {
        if (principal == null) {
            model.addAttribute("isUserLoggedIn", null);
        } else {
            User user = this.userService.getUserByEmail(principal.getName());
            model.addAttribute("isUserLoggedIn", user);
            model.addAttribute("loggedInUserRole", user.getRole());
        }
    }

    /*  Admin Category APIs */
    @RequestMapping(value = "/admin/add-category", method = RequestMethod.POST)
    public String addCategory(
            @ModelAttribute Category category, @RequestParam("image") MultipartFile image, HttpSession session
    ) {
        return this.categoryService.addCategory(category, image, session);
    }

    @RequestMapping(value = "/admin/manage-categories", method = RequestMethod.GET)
    public String manageCategories(HttpSession session, Principal principal, Model model) {
        return this.categoryService.manageCategories(session, principal, model);
    }

    @RequestMapping(value = "/admin/edit-category", method = RequestMethod.POST)
    public String updateCategory(
            @ModelAttribute Category category, @RequestParam("image") MultipartFile image, HttpSession session
    ) {
        return this.categoryService.updateCategory(category, image, session);
    }

    @RequestMapping(value = "/admin/delete-category/{category}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("category") String categoryToRemove, HttpSession session) {
        return this.categoryService.deleteCategory(categoryToRemove, session);
    }

    /* Public Category APIs */
    @RequestMapping("/category/{categoryName}")
    public String showCategoryProducts(
            @PathVariable("categoryName") String categoryName,
            Model model,
            HttpSession session
    ) {
        return this.productService.getProductsOfSpecificCategory(categoryName, model, session);
    }

}