package com.NguyenHoangTuan.ecommerce.service.category;

import com.NguyenHoangTuan.ecommerce.model.entity.Category;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.security.Principal;

 
public interface CategoryService {

    String addCategory(Category category, MultipartFile image, HttpSession session);

    String manageCategories(HttpSession session, Principal principal, Model model);

    String updateCategory(Category category, MultipartFile image, HttpSession session);

    String deleteCategory(String categoryToRemove, HttpSession session);

}
