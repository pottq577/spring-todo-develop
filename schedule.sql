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