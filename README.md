![header](https://capsule-render.vercel.app/api?type=Waving&color=auto&height=300&section=header&text=spring-todo-develop&fontSize=70&desc=Spring%20Boot를%20활용한%20일정%20관리%20프로젝트입니다.&descAlignY=30)

<br/>

# 🔗 목차

1. [📆 프로젝트 소개](#-프로젝트-소개)
2. [🕰️ 개발 기간](#%EF%B8%8F-개발-기간)
3. [📚 개발 환경](#-개발-환경)
4. [🌳 디렉토리 구조](#-디렉토리-구조)
5. [📝 프로젝트 명세](#-프로젝트-명세)

   5-1. [ERD](#erd)

   5-2. [API 명세서](#api-명세서)

6. [💭 마무리](#-마무리)

<br/>

# 🧮 프로젝트 소개

1️⃣ 일정 CRUD
<br/>
2️⃣ 유저 CRUD
<br/>
3️⃣ 회원가입
<br/>
4️⃣ 로그인 (인증)
<br/>
🆙 다양한 예외처리 적용하기
<br/>
~~🆙 비밀번호 암호화~~
<br/>
~~🆙 댓글 CRUD~~
<br/>
~~🆙 일정 페이징 조회~~

Spring Boot와 JPA를 활용해서 일정 관리 프로젝트의 백엔드 API를 구현한 프로젝트입니다.

Front-end는 구현하지 않고 데이터 통신과 DB와의 연동 위주로 작성되었습니다.

### 자세한 개발 과정은 아래 블로그를 참조해주세요.

<a href="https://velog.io/@pottq577/일정-관리-앱-발전-과제-day-1"><img src="https://img.shields.io/badge/일정 관리 앱 발전 과제 day1-20C997?style=for-the-badge&logo=Velog&logoColor=white"/></a>

<a href="https://velog.io/@pottq577/일정-관리-앱-발전-과제-day-2"><img src="https://img.shields.io/badge/일정 관리 앱 발전 과제 day2-20C997?style=for-the-badge&logo=Velog&logoColor=white"/></a>

<a href="https://velog.io/@pottq577/일정-관리-앱-발전-과제-day-3"><img src="https://img.shields.io/badge/일정 관리 앱 발전 과제 day3-20C997?style=for-the-badge&logo=Velog&logoColor=white"/></a>

<a href="https://velog.io/@pottq577/일정-관리-앱-발전-과제-day-4"><img src="https://img.shields.io/badge/일정 관리 앱 발전 과제 day4-20C997?style=for-the-badge&logo=Velog&logoColor=white"/></a>

<a href="https://velog.io/@pottq577/일정-관리-앱-발전-과제-day-5"><img src="https://img.shields.io/badge/일정 관리 앱 발전 과제 day5-20C997?style=for-the-badge&logo=Velog&logoColor=white"/></a>

<br/>

# 🕰️ 개발 기간

- 2025.03.31 ~ 2025.04.04 (총 5일)

<br/>

# 📚 기술 스택

### Language

[![My Skills](https://skillicons.dev/icons?i=java)](https://skillicons.dev)

### Backend

[![My Skills](https://skillicons.dev/icons?i=spring)](https://skillicons.dev)

### Database

[![My Skills](https://skillicons.dev/icons?i=mysql)](https://skillicons.dev)

### Development Tools

[![My Skills](https://skillicons.dev/icons?i=idea,postman)](https://skillicons.dev)

### SCM

[![My Skills](https://skillicons.dev/icons?i=git,github)](https://skillicons.dev)


<br/>

# 🌳 디렉토리 구조

```
spriing-todo-develop/
    ├──src/
    │   ├──main/java/com/example/springtododevelop/
    │   │   ├──config/
    │   │   │   └──WebConfig.java
    │   │   ├──controller/
    │   │   │   ├──AuthController.java
    │   │   │   ├──ScheduleController.java
    │   │   │   └──UserController.java
    │   │   ├──dto/
    │   │   │   ├──auth/
    │   │   │   │   ├──LoginRequestDto.java
    │   │   │   │   └──LoginResponseDto.java
    │   │   │   ├──schedules/
    │   │   │   │   ├──ScheduleDeleteRequestDto.java
    │   │   │   │   ├──ScheduleRequestDto.java
    │   │   │   │   ├──ScheduleResponseDto.java
    │   │   │   │   └──ScheduleUpdateRequestDto.java
    │   │   │   └──users/
    │   │   │   │   ├──UserDeleteRequestDto.java
    │   │   │   │   ├──UserRequestDto.java
    │   │   │   │   ├──UserResponseDto.java
    │   │   │   │   └──UserUpdateRequestDto.java
    │   │   ├──entity/
    │   │   │   ├──BaseEntity.java
    │   │   │   ├──Schedules.java
    │   │   │   └──Users.java
    │   │   ├──exception/
    │   │   │   ├──BusinessException.java
    │   │   │   └──ExceptionCode.java
    │   │   ├──filter/
    │   │   │   └──LoginFilter.java
    │   │   ├──handler/
    │   │   │   ├──ErrorResponse.java
    │   │   │   └──GlobalExceptionHandler.java
    │   │   ├──repository/
    │   │   │   ├──ScheduleRepository.java
    │   │   │   └──userRepository.java
    │   │   ├──service/
    │   │   │   ├──AuthService.java
    │   │   │   ├──ScheduleService.java
    │   │   │   └──UserService.java
    │   │   └──SpringTodoApplication.java
    │   ├──main/resources
    │   │   ├──static/
    │   │   │   ├──templates/
    │   │   │   └──application.properties
    ├── .gitignore
    ├──schedule.sql
    └──README.md
```

<br/>

# 📝 프로젝트 명세

## SQL

```sql
CREATE TABLE users
(
    user_id   BIGINT       NOT NULL AUTO_INCREMENT COMMENT '유저 식별자 ID',
    username  VARCHAR(50)  NOT NULL COMMENT '유저 이름',
    password  VARCHAR(255) NOT NULL COMMENT '유저 비밀번호',
    email     VARCHAR(255) NOT NULL COMMENT '유저 이메일',
    createdAt TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '유저 생성 날짜',
    updatedAt TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '유저 수정 날짜',
    PRIMARY KEY (user_id)
);

CREATE TABLE schedules
(
    schedule_id BIGINT      NOT NULL AUTO_INCREMENT COMMENT '일정 식별자 ID',
    user_id     BIGINT      NOT NULL COMMENT '유저 식별자 ID',
    title       VARCHAR(50) NOT NULL COMMENT '일정 제목',
    contents    TEXT        NOT NULL COMMENT '일정 내용',
    createdAt   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '일정 등록 날짜',
    updatedAt   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '일정 수정 날짜',
    PRIMARY KEY (schedule_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);
```

## ERD

### users 테이블

| 컬럼명       | 데이터 타입       | 제약조건                                                            | 설명        |
|-----------|--------------|-----------------------------------------------------------------|-----------|
| user_id   | BIGINT       | PK, AUTO_INCREMENT                                              | 유저 식별자 ID |
| username  | VARCHAR(50)  | NOT NULL                                                        | 유저 이름     |
| password  | VARCHAR(255) | NOT NULL                                                        | 유저 비밀번호   |
| email     | VARCHAR(255) | NOT NULL                                                        | 유저 이메일    |
| createdAt | TIMESTAMP    | NOT NULL, DEFAULT CURRENT_TIMESTAMP                             | 유저 생성 날짜  |
| updatedAt | TIMESTAMP    | NOT NULL, DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP | 유저 수정 날짜  |

### schedules 테이블

| 컬럼명         | 데이터 타입      | 제약조건                                                            | 설명        |
|-------------|-------------|-----------------------------------------------------------------|-----------|
| schedule_id | BIGINT      | PK, AUTO_INCREMENT                                              | 일정 식별자 ID |
| user_id     | BIGINT      | FK, NOT NULL                                                    | 유저 식별자 ID |
| title       | VARCHAR(50) | NOT NULL                                                        | 일정 제목     |
| contents    | TEXT        | NOT NULL                                                        | 일정 내용     |
| createdAt   | TIMESTAMP   | NOT NULL, DEFAULT CURRENT_TIMESTAMP                             | 일정 등록 날짜  |
| updatedAt   | TIMESTAMP   | NOT NULL, DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP | 일정 수정 날짜  |

### 관계

- users와 schedules는 1:N 관계
- schedules의 user_id는 users의 user_id를 참조하는 외래 키
- ON DELETE CASCADE 설정으로 users 테이블의 레코드가 삭제되면 관련된 schedules 레코드도 자동 삭제

### 제약조건

1. users 테이블
    - username: 최대 50자
    - password: 최대 255자
    - email: 최대 255자, 이메일 형식
    - createdAt, updatedAt: 자동으로 생성/수정 시간 기록

2. schedules 테이블
    - title: 최대 50자
    - contents: TEXT 타입으로 긴 내용 저장 가능
    - createdAt, updatedAt: 자동으로 생성/수정 시간 기록
    - user_id: 반드시 존재하는 users 테이블의 user_id를 참조해야 함

<br/>

[🛢️ ERDCloud 에서 보기](https://www.erdcloud.com/d/s6fsXWbYpkf4r43uv)

<br/>

## API 명세서

### 인증 API

#### 로그인

- **URL**: `/auth/login`
- **Method**: POST
- **Content-Type**: application/x-www-form-urlencoded
- **Request Parameters**:
    - `email`: String (이메일)
    - `password`: String (비밀번호)
- **Response**: 200 OK
  ```json
  {
    "userId": Long,
    "username": String,
    "password": String,
    "email": String
  }
  ```
- **Error Response**: 401 Unauthorized
  ```json
  {
    "status": 401,
    "code": "A001",
    "message": "로그인을 먼저 해주세요.",
    "reason": "로그인이 필요합니다."
  }
  ```

### 유저 API

#### 1. 유저 생성

- **URL**: `/api/users`
- **Method**: POST
- **Content-Type**: application/json
- **Request Body**:
  ```json
  {
    "username": String,    // 필수, 최대 15자
    "password": String,    // 필수, 8-20자
    "email": String       // 필수, 이메일 형식
  }
  ```
- **Response**: 201 Created
  ```json
  {
    "userId": Long,
    "username": String,
    "email": String,
    "createdAt": LocalDateTime,
    "updatedAt": LocalDateTime
  }
  ```
- **Error Response**: 400 Bad Request
  ```json
  {
    "status": 400,
    "code": "R001",
    "message": "Validation Exception 발생",
    "reason": "필드명:에러메시지"
  }
  ```

#### 2. 전체 유저 조회

- **URL**: `/api/users`
- **Method**: GET
- **Response**: 200 OK
  ```json
  [
    {
      "userId": Long,
      "username": String,
      "email": String,
      "createdAt": LocalDateTime,
      "updatedAt": LocalDateTime
    }
  ]
  ```

#### 3. 특정 유저 조회

- **URL**: `/api/users/{userId}`
- **Method**: GET
- **Response**: 200 OK
  ```json
  {
    "userId": Long,
    "username": String,
    "email": String,
    "createdAt": LocalDateTime,
    "updatedAt": LocalDateTime
  }
  ```
- **Error Response**: 404 Not Found
  ```json
  {
    "status": 404,
    "code": "U002",
    "message": "유저 정보를 찾을 수 없습니다."
  }
  ```

#### 4. 유저 정보 수정

- **URL**: `/api/users/{userId}`
- **Method**: PATCH
- **Content-Type**: application/json
- **Request Body**:
  ```json
  {
    "username": String,    // 선택, 최대 15자
    "oldPassword": String, // 필수, 8-20자
    "newPassword": String, // 필수, 8-20자
    "email": String       // 선택, 이메일 형식
  }
  ```
- **Response**: 200 OK
  ```json
  {
    "userId": Long,
    "username": String,
    "email": String,
    "createdAt": LocalDateTime,
    "updatedAt": LocalDateTime
  }
  ```
- **Error Response**:
    - 400 Bad Request (유효성 검사 실패)
    - 403 Forbidden (비밀번호 불일치)
    - 404 Not Found (사용자 없음)

#### 5. 유저 삭제

- **URL**: `/api/users/{userId}`
- **Method**: DELETE
- **Content-Type**: application/json
- **Request Body**:
  ```json
  {
    "password": String    // 필수, 8-20자
  }
  ```
- **Response**: 200 OK
- **Error Response**:
    - 400 Bad Request (유효성 검사 실패)
    - 403 Forbidden (비밀번호 불일치)
    - 404 Not Found (사용자 없음)

### 일정 API

#### 1. 일정 생성

- **URL**: `/api/schedules`
- **Method**: POST
- **Content-Type**: application/json
- **Request Body**:
  ```json
  {
    "userId": Long,      // 필수
    "title": String,     // 필수, 최대 10자
    "contents": String   // 필수
  }
  ```
- **Response**: 201 Created
  ```json
  {
    "userId": Long,
    "scheduleId": Long,
    "title": String,
    "contents": String,
    "createdAt": LocalDateTime,
    "updatedAt": LocalDateTime
  }
  ```
- **Error Response**:
    - 400 Bad Request (유효성 검사 실패)
    - 404 Not Found (사용자 없음)

#### 2. 전체 일정 조회

- **URL**: `/api/schedules`
- **Method**: GET
- **Response**: 200 OK
  ```json
  [
    {
      "userId": Long,
      "scheduleId": Long,
      "title": String,
      "contents": String,
      "createdAt": LocalDateTime,
      "updatedAt": LocalDateTime
    }
  ]
  ```

#### 3. 특정 일정 조회

- **URL**: `/api/schedules/{scheduleId}`
- **Method**: GET
- **Response**: 200 OK
  ```json
  {
    "userId": Long,
    "scheduleId": Long,
    "title": String,
    "contents": String,
    "createdAt": LocalDateTime,
    "updatedAt": LocalDateTime
  }
  ```
- **Error Response**: 404 Not Found
  ```json
  {
    "status": 404,
    "code": "S001",
    "message": "일정 정보를 찾을 수 없습니다."
  }
  ```

#### 4. 일정 수정

- **URL**: `/api/schedules/{scheduleId}`
- **Method**: PATCH
- **Content-Type**: application/json
- **Request Body**:
  ```json
  {
    "password": String,   // 필수, 8-20자
    "title": String,      // 선택, 최대 10자
    "contents": String    // 선택
  }
  ```
- **Response**: 200 OK
  ```json
  {
    "userId": Long,
    "scheduleId": Long,
    "title": String,
    "contents": String,
    "createdAt": LocalDateTime,
    "updatedAt": LocalDateTime
  }
  ```
- **Error Response**:
    - 400 Bad Request (유효성 검사 실패)
    - 403 Forbidden (비밀번호 불일치)
    - 404 Not Found (일정 없음)

#### 5. 일정 삭제

- **URL**: `/api/schedules/{scheduleId}`
- **Method**: DELETE
- **Content-Type**: application/json
- **Request Body**:
  ```json
  {
    "password": String    // 필수, 8-20자
  }
  ```
- **Response**: 200 OK
- **Error Response**:
    - 400 Bad Request (유효성 검사 실패)
    - 403 Forbidden (비밀번호 불일치)
    - 404 Not Found (일정 없음)

### 공통 에러 응답

#### 401 Unauthorized

```json
{
  "status": 401,
  "code": "A001",
  "message": "로그인을 먼저 해주세요.",
  "reason": "로그인이 필요합니다."
}
```

#### 403 Forbidden

```json
{
  "status": 403,
  "code": "U001",
  "message": "비밀번호가 일치하지 않습니다."
}
```

#### 404 Not Found

```json
{
  "status": 404,
  "code": "U002",
  "message": "유저 정보를 찾을 수 없습니다."
}
```

또는

```json
{
  "status": 404,
  "code": "S001",
  "message": "일정 정보를 찾을 수 없습니다."
}
```

### 인증 요구사항

- 로그인하지 않은 사용자는 `/auth/login` 과 `POST` 형식의 `/api/users` 를 제외한 모든 API에 접근할 수 없습니다.
- 모든 API 요청은 세션 기반 인증을 사용합니다.
- 로그인 시 세션은 30분 동안 유지됩니다.

### 유효성 검사 규칙

- username: 최대 15자
- password: 8-20자
- email: 이메일 형식 준수
- title: 최대 10자

<br/>

자세한 내용은 아래 노션에서 확인해주세요.

[📓 Notion 에서 보기](https://legendary-jaguar-30f.notion.site/Schedule-developed-API-Spec-1c765d3c37e580e49332e46e6f2ff87a?pvs=74)

<br/>

## 💭 마무리

### 느낀 점

JDBC보다 JPA를 쓰는 게 훨씬 편하다고 느꼈습니다.

쿠키/세션에 발을 한 번 담궜다는 걸로 만족을 하고 있습니다.

### 아쉬운 점

코드를 작성하면서 이론적/개념적으로 이해하고 사용한 부분이 적어서 아쉽습니다.

도메인 별로 디렉토리 구조를 설계하지 않았던 것도 이제보니 조금 아쉽게 느껴졌습니다.

<br/>

## 🙋🏻‍♂️ 정보

[![Velog's GitHub stats](https://velog-readme-stats.vercel.app/api/badge?name=pottq577)](https://velog.io/@pottq577)
