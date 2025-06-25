## \[dev-beta] - 2025-06-15

### ✨ Added

* **Authentication (Auth) system** has been integrated.

    * Enables user registration, login, and JWT-based authentication.
* **JWT (JSON Web Token) support** added:

    * `JwtUtil.kt` handles token generation and validation.
* **User management foundations implemented:**

    * `User`, `Role`, and `UserProfile` models have been created.
    * Corresponding repositories (`UserRepository`, `UserProfileRepository`) added.
* **DTO classes added:**

    * `LoginRequest.kt`, `RegisterRequest.kt`, `RegisterResponse.kt`
* **Service and controller layers introduced:**

    * `AuthController.kt` exposes REST endpoints.
    * `AuthService`, `AuthServiceImpl`, and `AuthServiceHelper` handle business logic.
* **Spring Security configuration completed:**

    * `JwtFilter`, `CustomUserDetailsService`, and `SecurityConfig` classes added.
* **Password encryption mechanism implemented:**

    * `PasswordEncoderConfig.kt` uses BCrypt for secure password hashing.
* **Custom exception classes introduced:**

    * Includes `EmailAlreadyRegisteredException`, `PasswordIncorrectException`, `UserNotFoundException`, and others.
* **User mapping support:**

    * `UserMapper.kt` for converting between model and DTO.

### 🛠️ Structural Improvements

* Project folder structure has been initialized.

    * Modules such as `animes`, `user`, and `common` were clearly separated.
    * Codebase is now more modular and organized.

### 🏗️ Changed

* **Login functionality refactored:**

    * Improved validation, error handling, and token generation to ensure more secure login flow.

## [Dev Version] - 2025-06-20
### Added
- AnimeApi added
- AnimeController added
- AnimeService added
- AnimeMapper added
- AnimeNotFoundException added
- dto/request and dto/response packages added
- AnimeResponseDto added



# 📦 Changelog

## \[dev-beta] - 2025-06-25

### ✨ Features

* Added `LikeEpisode` entity
* Added and implemented `LikeService`
* Added Android API support to `EpisodeController`
* Implemented `EpisodeServiceImpl`
* Switched JWT storage from `localStorage` to HttpOnly cookies in auth module
* Integrated `Bucket4j` for API rate limiting
* Implemented season creation feature (`SeasonController`, `SeasonApi`, `SeasonService`)
* Added `setAnimeStatus` method in `AnimeService`
* Integrated Swagger UI for API documentation
* Added dependency: `org.bouncycastle:bcprov-jdk15to18:1.81` for Argon2 password hashing

### ♻️ Refactoring

* Removed unnecessary `RegisterResponse` from `readurant` DTO
* Ensured exception messages are non-nullable
* Replaced `jakarta.transaction.Transactional` with Spring's `@Transactional` in `AnimeService`
* Simplified `update()` method in `AnimeService`
* Added `updateFromRequest` method to `AnimeMapper` and `SeasonMapper` for better readability
* Refactored `SeasonApi` structure
* Changed API endpoint from `/season/{animeid}` to `/season/anime/{animeid}`
* Renamed `model` package to `entity`
* Refactored `AuthService` and `AuthController` to return JWT after registration

### 🐛 Bug Fixes

* Fixed several API endpoints
* Refactored some API logic for better consistency and behavior

### 📃 Documentation

* Integrated Swagger UI
* Minor formatting and whitespace fixes in code



