package com.NguyenHoangTuan.ecommerce.service.email;

 
public interface EmailService {

    boolean sendEmail(String to, String subject, String message);

}
