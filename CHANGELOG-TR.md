## \[dev-beta] - 2025-06-15

### ✨ Yeni Eklenenler

* **Kimlik Doğrulama (Auth) Sistemi** entegre edildi.

    * Kullanıcıların kayıt olma, giriş yapma ve JWT ile kimlik doğrulama işlemleri sağlandı.
* **JWT (JSON Web Token) desteği** eklendi:

    * `JwtUtil.kt` ile erişim token’ları üretme ve doğrulama mekanizması kuruldu.
* **Kullanıcı yönetimi temelleri oluşturuldu:**

    * `User`, `Role` ve `UserProfile` modelleri oluşturuldu.
    * İlgili repository sınıfları (`UserRepository`, `UserProfileRepository`) eklendi.
* **DTO sınıfları eklendi:**

    * `LoginRequest.kt`, `RegisterRequest.kt`, `RegisterResponse.kt`
* **Servis ve controller katmanı oluşturuldu:**

    * `AuthController.kt` ile REST uç noktaları tanımlandı.
    * `AuthService`, `AuthServiceImpl`, `AuthServiceHelper` sınıflarıyla iş mantığı kuruldu.
* **Spring Security yapılandırması tamamlandı:**

    * `JwtFilter`, `CustomUserDetailsService`, `SecurityConfig` eklendi.
* **Şifreleme mekanizması** uygulandı:

    * `PasswordEncoderConfig.kt` ile BCrypt kullanılarak güvenli parola saklama sağlandı.
* **Özel hata sınıfları geliştirildi:**

    * `EmailAlreadyRegisteredException`, `PasswordIncorrectException`, `UserNotFoundException` ve diğerleri eklendi.
* **Kullanıcı veri dönüşümleri için** `UserMapper.kt` oluşturuldu.

### 🛠️ Yapısal Geliştirmeler

* Projenin temel klasör yapısı oluşturuldu.

    * `animes`, `user`, `common` gibi modüller net şekilde ayrıldı.
    * Kod organizasyonu modüler hale getirildi.

### 🏗️ İyileştirmeler

* Giriş işlemi (`login`) yeniden yazıldı.

    * Geliştirilmiş doğrulama, hata yönetimi ve token üretimi ile daha güvenli hale getirildi.

