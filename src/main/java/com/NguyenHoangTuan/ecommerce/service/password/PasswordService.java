package com.NguyenHoangTuan.ecommerce.service.password;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;

 
public interface PasswordService {

    ResponseEntity<String> processForgotPassword(String email, HttpSession session);

    ResponseEntity<String> verifyOtp(String otp, HttpSession session);

    ResponseEntity<String> processNewPassword(String newPassword, String confirmNewPassword, HttpSession session);

}
