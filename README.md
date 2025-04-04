![header](https://capsule-render.vercel.app/api?type=Waving&color=auto&height=300&section=header&text=spring-todo-develop&fontSize=70&desc=Spring%20Boot를%20활용한%20일정%20관리%20프로젝트입니다.&descAlignY=30)

<br/>

## 🔗 목차

1. [📆 프로젝트 소개](#-프로젝트-소개)
2. [🕰️ 개발 기간](#%EF%B8%8F-개발-기간)
3. [📚 개발 환경](#-개발-환경)
4. [🌳 디렉토리 구조](#-디렉토리-구조)
5. [📝 프로젝트 명세](#-프로젝트-명세)

   5-1. [ERD](#erd)

   5-2. [API 명세서](#api-명세서)

6. [🛠️ 주요 기능](#%EF%B8%8F-주요-기능)

7. [💭 마무리](#-마무리)

<br/>

## 🧮 프로젝트 소개

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

## 🕰️ 개발 기간

- 2025.03.20 ~ 2025.03.26 (총 6일)

<br/>

## 📚 기술 스택

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

## 🌳 디렉토리 구조

```java
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

## 📝 프로젝트 명세

### ERD

[🛢️ ERDCloud 에서 보기](https://www.erdcloud.com/d/s6fsXWbYpkf4r43uv)

### API 명세서

자세한 내용은 아래 노션에서 확인해주세요.

[📓 Notion 에서 보기](https://legendary-jaguar-30f.notion.site/Schedule-developed-API-Spec-1c765d3c37e580e49332e46e6f2ff87a?pvs=74)

<br/>

## 🛠️ 주요 기능

<br/>

## 💭 마무리

### 느낀 점

### 아쉬운 점

<br/>

## 🙋🏻‍♂️ 정보

[![Velog's GitHub stats](https://velog-readme-stats.vercel.app/api/badge?name=pottq577)](https://velog.io/@pottq577)
