package com.NguyenHoangTuan.ecommerce.service.home;

import com.NguyenHoangTuan.ecommerce.model.entity.Category;
import com.NguyenHoangTuan.ecommerce.model.entity.Orders;
import com.NguyenHoangTuan.ecommerce.model.entity.Product;
import com.NguyenHoangTuan.ecommerce.model.entity.User;
import com.NguyenHoangTuan.ecommerce.repository.CategoryRepository;
import com.NguyenHoangTuan.ecommerce.repository.ProductRepository;
import com.NguyenHoangTuan.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

 
@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public void home(final Model model) {
        List<Category> categories = this.categoryRepository.findAll();
        List<Product> products = this.productRepository.findAll();

        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
    }

    @Override
    public void cart(final Principal principal, final Model model) {
        if (principal != null) {
            User user = this.userRepository.getUserByEmail(principal.getName());

            int totalCartPrice = 0;
            for (Orders o : user.getCart()) {
                totalCartPrice += o.getOrderPrice() * o.getProductQuantities();
            }

            model.addAttribute("userCartItems", user.getCart());
            model.addAttribute("totalCartPrice", totalCartPrice);
        }
    }

    @Override
    public void searchProduct(final String searchKeywords, final Model model) {
        List<Product> products = new ArrayList<>();
        String[] keywords = searchKeywords.split(" ");
        boolean isCategoryFound = false;

        for (String string : keywords) {
            if (string.length() > 2) {
                List<Product> category = this.productRepository.findProductsByCategoryContainsIgnoreCase(string);
                for (Product product : category) {
                    if (!products.contains(product)) {
                        products.add(product);
                        if (!isCategoryFound) {
                            System.out.println("called");
                            isCategoryFound = true;
                            model.addAttribute("probableSearchCategory", product.getCategory());
                        }
                    }
                }
            }
        }

        for (String string : keywords) {
            if (string.length() > 2) {
                List<Product> name = this.productRepository.findProductsByNameContainsIgnoreCase(string);
                for (Product product : name) {
                    if (!products.contains(product)) {
                        products.add(product);
                        if (!isCategoryFound) {
                            System.out.println("called");
                            isCategoryFound = true;
                            model.addAttribute("probableSearchCategory", product.getCategory());
                        }
                    }
                }
            }
        }

        for (String string : keywords) {
            if (string.length() > 2) {
                List<Product> description = this.productRepository.findProductsByDescriptionContainsIgnoreCase(string);
                for (Product product : description) {
                    if (!products.contains(product)) {
                        products.add(product);
                    }
                }
            }
        }

        if (model.getAttribute("probableSearchCategory") == null) {
            model.addAttribute("probableSearchCategory", "");
        }

        model.addAttribute("searchProducts", products);
        model.addAttribute("categories", this.categoryRepository.findAll());
        model.addAttribute("title", "SoutShopping - " + searchKeywords);

    }

}
