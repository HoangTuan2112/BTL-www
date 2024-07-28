package com.NguyenHoangTuan.ecommerce.repository;

import com.NguyenHoangTuan.ecommerce.model.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReviewRepository extends JpaRepository<UserReview, String> {

    List<UserReview> findUserReviewByProductNameContainsIgnoreCase(String productName);

}