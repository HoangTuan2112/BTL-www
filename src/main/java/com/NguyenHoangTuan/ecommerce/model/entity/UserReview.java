package com.NguyenHoangTuan.ecommerce.model.entity;

import com.NguyenHoangTuan.ecommerce.utils.EcommerceUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class UserReview {

    @Id
    private String reviewId;

    private String productName;

    private String userName;

    private int ratingStar;

    @Column(length = 1024)
    private String reviewMessage;

    public UserReview() {
        this.reviewId = EcommerceUtils.generateReviewRatingId();
    }

}