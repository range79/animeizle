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

## [Dev Version] - 2025-06-20
### Eklendi
- AnimeApi eklendi
- AnimeController eklendi
- AnimeService eklendi
- AnimeMapper eklendi
- AnimeNotFoundException eklendi
- dto/request ve dto/response paketleri eklendi
- AnimeResponseDto eklendi


# 📦 Changelog

## \[dev-beta] - 2025-06-25

### ✨ Features

* `LikeEpisode` entity eklendi
* `LikeService` sınıfı tanımlandı ve uygulandı
* `EpisodeController` içerisine Android API desteği eklendi
* `EpisodeServiceImpl` implementasyonu tamamlandı
* JWT sistemi localStorage'dan HttpOnly Cookie'ye geçirildi (`auth` tarafında)
* `Bucket4j` rate limiting kütüphanesi projeye eklendi
* Yeni sezon oluşturma fonksiyonu eklendi (`SeasonController`, `SeasonApi`, `SeasonService`)
* Anime'nin durumunu değiştirme özelliği eklendi (`setAnimeStatus`)
* Swagger UI desteği eklendi
* Argon2 şifreleme için `bcprov-jdk15to18:1.81` bağımlılığı eklendi

### ♻️ Refactor

* `readurant` DTO'dan gereksiz `RegisterResponse` kaldırıldı
* `not exception` mesajları nullable olmayacak şekilde düzenlendi
* `AnimeService`'de transactional anotasyon `jakarta` yerine `spring` üzerinden tanımlandı
* `AnimeService.update()` fonksiyonu sadeleştirildi
* Mapper'lara (`AnimeMapper`, `SeasonMapper`) `updateFromRequest` metodu eklendi
* `SeasonApi` yeniden yapılandırıldı
* API endpoint değiştirildi: `/season/{animeid}` → `/season/anime/{animeid}`
* Model klasörü `entity` olarak yeniden adlandırıldı
* `AuthService` ve `AuthController` refactor edildi: register sonrası artık JWT token döner

### 🛠 Bugfixes

* Bazı endpoint’ler düzeltildi
* Bazı endpoint’ler refactor edildi

### 📃 Documentation

* Swagger UI entegrasyonu eklendi
* Dosyalarda ufak boşluk (space) düzeltmeleri yapıldı

