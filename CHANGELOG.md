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
