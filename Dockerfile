# Bước 1: Sử dụng base image với OpenJDK 17
FROM openjdk:17-jdk-slim

# Bước 2: Thiết lập thư mục làm việc trong container
WORKDIR /app

# Bước 3: Copy file JAR vào thư mục làm việc
COPY target/ShopThietBIMang-1.0.0.jar /app/ShopThietBIMang-1.0.0.jar

# Bước 4: Expose cổng mặc định của Spring Boot (8080)
# Lưu ý: Heroku sử dụng biến môi trường PORT nên ta cần sử dụng biến này để cấu hình động cổng khi chạy ứng dụng.
EXPOSE 8080

# Bước 5: Lệnh để chạy ứng dụng
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-Dserver.port=${PORT}", "-jar", "/app/ShopThietBIMang-1.0.0.jar"]
