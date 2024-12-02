CREATE TABLE member
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    memberId VARCHAR(255) NOT NULL,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    status   VARCHAR(50)  NOT NULL
);

CREATE TABLE milestone
(
    milestoneId   BIGINT AUTO_INCREMENT PRIMARY KEY,
    milestoneName VARCHAR(255) NOT NULL
);


CREATE TABLE project
(
    project_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    status       VARCHAR(50)  NOT NULL,
    adminId      BIGINT       NOT NULL
);

CREATE TABLE tag
(
    tagId   BIGINT AUTO_INCREMENT PRIMARY KEY,
    tagName VARCHAR(255) NOT NULL
);


CREATE TABLE task
(
    taskId  BIGINT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(255) NOT NULL
);





