
# AnimeIzle Backend Service

[![Click here for Turkish README](https://img.shields.io/badge/Readme-Türkçe-blue?style=for-the-badge&logo=markdown)](README_TR.md)

---

![GitHub repo size](https://img.shields.io/github/repo-size/range79/rpms-server?style=flat-square)
![GitHub issues](https://img.shields.io/github/issues/range79/rpms-server?style=flat-square)
![GitHub license](https://img.shields.io/github/license/range79/rpms-server?style=flat-square)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=kotlin&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white)

---


AnimeIzle is a backend service developed to enhance users’ anime watching experience. It is built with Kotlin and Spring Boot.

---

## 🚀 Features

- Management of animes, seasons, and episodes  
- User profiles and favorite animes  
- JWT-based authentication  
- REST API architecture  

---

## 🛠 Technologies

- Kotlin  
- Spring Boot  
- PostgreSQL  
- JWT  

---

## 📦 Installation

1. Clone the project:  
```bash
git clone https://github.com/range79/animeizle.git
````

2. Install dependencies and build the project:

```bash
./gradlew build
```



### 3. Configure database settings in `application.yml` or `application.properties`.

**Example `application.properties`:**

```properties
spring.application.name=aniseyir
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=someusername
spring.datasource.password=testpw
spring.jpa.hibernate.ddl-auto=update

jwt.secret=   # secret must be in base64 format
jwt.duration=

argon2.saltLength=
argon2.hashLength=
argon2.parallelism=
argon2.memory=
argon2.iterations=
https.enable=false  # if you are using https make it true
```

---

### 4. Run PostgreSQL service with Docker Compose.

**Example `compose.yml`:**

```yaml
services:
  postgres:
    image: 'postgres:latest'
    environment:
      - 'POSTGRES_DB=mydatabase'
      - 'POSTGRES_PASSWORD=testpw'
      - 'POSTGRES_USER=someusername'
    ports:
      - '5432:5432'
```

---

5. Run the application:

```bash
 ./gradlew bootRun
```

---

## 📜 License and Usage Terms

This project is licensed under **RangeLicense Light v1.0**.
You may explore, learn from, and use it for personal projects.
However, unauthorized publishing, distribution, API use, and commercial use are prohibited.
API access requires permission and an API key.

See the [LICENSE](./LICENSE) file for full license details.

---

## 📝 Changelog

Check the [CHANGELOG.md](./CHANGELOG.md) file for a full list of significant changes.

---

## 🤝 Contributing

To contribute:

* Fork the repo
* Create a new branch (`git checkout -b feature/your-feature`)
* Commit your changes
* Submit a pull request

---

## 📬 Contact

For questions, suggestions, or API access:
**[darkrange6@gmail.com](mailto:darkrange6@gmail.com)**

---

*Thank you and happy coding!*


