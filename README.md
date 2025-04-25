# 💳 결제 시뮬레이터 프로젝트

Spring Boot 기반으로 **전자 결제 흐름 전 과정을 시뮬레이션**하는 학습용 프로젝트입니다.  
가맹점 서버 → PG 서버 → 카드사 서버까지 **3단계 분리 구조**로 구성하여,  
실제 결제처럼 주문 → 결제 요청 → 승인 → 콜백(Webhook) → 상태 반영까지 흐름을 직접 구현합니다.

<br><br>
---

## 📁 폴더별 구성

- `payment-merchant-server`: 가맹점 서버 – 사용자, 상품, 주문 생성 및 Webhook 수신 처리
- `payment-pg-server`: PG 서버 – 결제 준비, TID 발급, 카드사 승인 요청, Webhook 전송
- `payment-card-server`: 카드사 서버 – 승인 응답 시뮬레이션

<br><br>
---
## ✅ 프로젝트 목표

- 전자 결제 흐름 구조에 대한 완벽한 이해
- RESTful API 기반의 결제 시스템 백엔드 구현
- 가맹점 / PG사 / 카드사 서버 간 API 설계 및 연동 경험
- Swagger, H2 Console, MockMvc 테스트 기반 실습

<br><br>
---

## 🛠 시스템 구성

```
[Client]
   ↓
[Merchant Server] → 주문 생성
   ↓
[PG Server] → 결제 요청, TID 생성
   ↓
[Card Server] → 승인 응답 시뮬레이션
   ↑
[PG Server] → 승인 결과 저장 + Webhook 전송
   ↑
[Merchant Server] → 결제 상태 반영
```

<br><br>
---

## ⚙️ 기술 스택

| 구분 | 사용 기술 |
|------|------------|
| Language | Java 17 |
| Framework | Spring Boot 3.4.4 |
| ORM | Spring Data JPA |
| Build Tool | Gradle |
| Database | H2 (in-memory, 테스트용) |
| 인증 (예정) | API Key, JWT |
| 문서화 | Swagger (springdoc-openapi) |
| 테스트 | JUnit 5, MockMvc |
| 기타 | Lombok, Validation, HikariCP |

<br><br>
---

## 📌 주요 기능

### 가맹점 서버
- 사용자 등록 및 조회
- 상품 등록 및 조회
- 주문 생성 (`POST /api/orders`)
- Webhook 수신 후 주문 상태 업데이트

### PG 서버
- 결제 준비 (`POST /api/payments/ready`) – API-KEY 검증, TID 발급
- 카드사로 승인 요청 (`POST /api/payments/approve`)
- Webhook 전송 (`POST /api/payments/webhook`)
- 거래 로그 및 에러 로그 기록

### 카드사 서버
- 승인 응답 시뮬레이션 (`POST /api/approve`)
- 승인 결과 저장

<br><br>
---

## 💻 실행 방법

```bash
# 1. 전체 프로젝트 클론
git clone https://github.com/wooZzing/pg-payment-simulator.git
cd pg-payment-simulator

# 2. 각 서버 실행
cd payment-merchant-server
./gradlew bootRun

cd ../payment-pg-server
./gradlew bootRun

cd ../payment-card-server
./gradlew bootRun
```
<br><br>
---

## 📃 개발자 도구
### 가맹점 서버
- H2 Console: `http://localhost:8081/h2-console`
  - JDBC URL: `jdbc:h2:mem:merchantdb`
- Swagger UI(예정): `http://localhost:8081/swagger-ui/index.html`

### PG 서버
- H2 Console: `http://localhost:8082/h2-console`
  - JDBC URL: `jdbc:h2:mem:pgdb`
- Swagger UI(예정): `http://localhost:8082/swagger-ui/index.html`

### 카드사 서버
- H2 Console: `http://localhost:8083/h2-console`
  - JDBC URL: `jdbc:h2:mem:carddb`
- Swagger UI(예정): `http://localhost:8083/swagger-ui/index.html`

<br><br>
---

## 💡 기타 참고

아직 전자결제 시스템을 실무에서 연동해본 경험은 없지만,  
NHN KCP, KG이니시스, Toss Payments 등의 공식 문서를 참고해  
결제 프로세스를 학습해왔습니다.

이 프로젝트는 그러한 학습을 바탕으로  
실제 결제 흐름과 구조를 Spring Boot로 구현한 **시뮬레이션 프로젝트**입니다.

실제 결제를 연동하는 것이 아닌,  
**전자결제 시스템의 구조와 흐름을 이해하고 구현하는 것**에 목적이 있습니다.

<br><br>
---

## 👨‍💻 Author

**우찡 (WooZzing)**  

Email: ohwoo88@naver.com

Blog: https://development-world.tistory.com
