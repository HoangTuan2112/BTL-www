package com.NguyenHoangTuan.ecommerce.service.firebase;

import org.springframework.web.multipart.MultipartFile;

 
public interface FirebaseService {

    String upload(MultipartFile multipartFile, String fileName);

    boolean delete(String fileUrl);

}
