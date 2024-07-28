package com.NguyenHoangTuan.ecommerce.repository;

import com.NguyenHoangTuan.ecommerce.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
