
# AnimeIzle Backend Service

[![Click here for English README](https://img.shields.io/badge/Readme-English-blue?style=for-the-badge&logo=markdown)](README.md)

---

AnimeIzle, kullanıcıların anime izleme deneyimini kolaylaştırmak için geliştirilmiş bir backend servisidir. Kotlin ve Spring Boot ile geliştirilmiştir.

---

## 🚀 Özellikler

- Anime, sezon ve bölüm yönetimi  
- Kullanıcı profili ve favori animeler  
- JWT tabanlı kimlik doğrulama  
- REST API yapısı  

---

## 🛠 Teknolojiler

- Kotlin  
- Spring Boot  
- PostgreSQL  
- JWT  

---

## 📦 Kurulum

1. Projeyi klonlayın:  
```bash
git clone https://github.com/range79/animeizle.git
````

2. Bağımlılıkları yükleyin ve projeyi derleyin:

```bash
./gradlew build
```

---

### 3. Veritabanı ayarlarını `application.yml` veya `application.properties` içinde yapılandırın.

**Örnek `application.properties`:**

```properties
spring.application.name=aniseyir
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=someusername
spring.datasource.password=testpw
spring.jpa.hibernate.ddl-auto=update

jwt.secret=   # base64 formatında secret girilmeli
jwt.duration=

argon2.saltLength=
argon2.hashLength=
argon2.parallelism=
argon2.memory=
argon2.iterations=
```

---

### 4. PostgreSQL servisini Docker Compose ile çalıştırın.

**Örnek `compose.yml`:**

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

**Not:**

* Docker Compose dosyasını çalıştırdıktan sonra `application.properties` dosyan ile bağlantı kurabilirsin.

---


5. Uygulamayı başlatın:

```bash
 ./gradlew bootRun
```

---

## 📜 Lisans ve Kullanım Koşulları

Bu proje **RangeLicense Light v1.0** ile lisanslanmıştır.
Projeyi inceleyebilir, öğrenebilir ve kişisel projelerinizde kullanabilirsiniz.
Ancak; izinsiz yayınlama, dağıtım, API kullanımı ve ticari kullanım yasaktır.
API erişimi için izin ve anahtar gereklidir.

Detaylı lisans metni için [LICENSE](./LICENSE-TR) dosyasına bakınız.

---

## 📝 Changelog

Projede yapılan önemli değişikliklerin tamamını görmek için [CHANGELOG.md](./CHANGELOG-TR.md) dosyasına göz atabilirsiniz.

---

## 🤝 Katkıda Bulunma

Katkıda bulunmak için:

* Fork yapın
* Yeni bir branch açın (`git checkout -b feature/özellik-adi`)
* Değişikliklerinizi commit edin
* Pull request gönderin

---

## 📬 İletişim

Sorularınız, önerileriniz veya API erişimi için:
**[darkrange6@gmail.com](mailto:darkrange6@gmail.com)**

---

*Teşekkürler, iyi çalışmalar!*

