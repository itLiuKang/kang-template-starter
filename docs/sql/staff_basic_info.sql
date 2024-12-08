-- 创建数据库
CREATE DATABASE KANGTEMPLATE;

-- 使用数据库
USE KANGTEMPLATE;

-- 创建职员基本信息表
CREATE TABLE STAFF_BASIC_INFO
(
    STAFF_NO    BIGINT            NOT NULL AUTO_INCREMENT COMMENT '员工唯一标识符，主键' PRIMARY KEY,
    STAFF_NAME  VARCHAR(50)       NOT NULL COMMENT '员工姓名',
    GENDER      ENUM ('男', '女') NOT NULL COMMENT '员工性别',
    PHONE       VARCHAR(15) COMMENT '联系电话',
    EMAIL       VARCHAR(100) COMMENT '电子邮件地址',
    HIRE_DATE   DATE              NOT NULL COMMENT '入职日期',
    POSITION    VARCHAR(50)       NOT NULL COMMENT '职位',
    DEPARTMENT  VARCHAR(50)       NOT NULL COMMENT '部门',
    BASE_SALARY DECIMAL(10, 2)    NOT NULL DEFAULT 0.00 COMMENT '基本工资，单位：人民币',
    IS_ACTIVE   BOOLEAN           NOT NULL DEFAULT TRUE COMMENT '是否在职，TRUE表示在职，FALSE表示离职'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 创建索引
CREATE INDEX idx_staff_name ON STAFF_BASIC_INFO (STAFF_NAME);
CREATE INDEX idx_hire_date ON STAFF_BASIC_INFO (HIRE_DATE);
CREATE INDEX idx_department ON STAFF_BASIC_INFO (DEPARTMENT);

-- 插入数据示例
INSERT INTO STAFF_BASIC_INFO (STAFF_NAME, GENDER, PHONE, EMAIL, HIRE_DATE, POSITION, DEPARTMENT, BASE_SALARY, IS_ACTIVE)
VALUES ('张三', '男', '13800138000', 'zhangsan@example.com', '2020-01-15', '软件工程师', '技术部', 6000.00, TRUE),
       ('李四', '女', '13900139000', 'lisi@example.com', '2019-12-20', '项目经理', '运营部', 7500.00, TRUE),
       ('王五', '男', '15000150000', 'wangwu@example.com', '2018-11-01', '产品经理', '产品部', 7200.00, TRUE),
       ('赵六', '女', '15100151000', 'zhaoliu@example.com', '2022-07-10', '人事专员', '人事部', 6500.00, TRUE),
       ('孙七', '男', '15200152000', 'sunqi@example.com', '2021-03-15', '系统分析师', '技术部', 6800.00, TRUE),
       ('周八', '女', '15300153000', 'zhouba@example.com', '2020-10-25', 'UI设计师', '设计部', 7000.00, TRUE),
       ('吴九', '男', '15400154000', 'wujio@example.com', '2023-01-10', '软件工程师', '技术部', 6000.00, TRUE),
       ('郑十', '女', '15500155000', 'zhengshi@example.com', '2017-06-18', '行政助理', '行政部', 5000.00, FALSE),
       ('冯十一', '男', '15600156000', 'fengshi@example.com', '2018-05-22', '项目经理', '运营部', 7500.00, TRUE),
       ('陈十二', '女', '15700157000', 'chen12@example.com', '2019-04-12', '产品经理', '产品部', 7200.00, TRUE),
       ('褚十三', '男', '15800158000', 'chu13@example.com', '2020-02-01', '人事专员', '人事部', 6500.00, TRUE),
       ('卫十四', '女', '15900159000', 'wei14@example.com', '2022-08-20', 'UI设计师', '设计部', 7000.00, TRUE),
       ('董十五', '男', '16000160000', 'dong15@example.com', '2023-06-10', '系统分析师', '技术部', 6800.00, TRUE),
       ('杨十六', '女', '16100161000', 'yang16@example.com', '2019-07-25', '行政助理', '行政部', 5000.00, TRUE),
       ('辛十七', '男', '16200162000', 'xin17@example.com', '2021-10-10', '软件工程师', '技术部', 6000.00, TRUE),
       ('戊十八', '女', '16300163000', 'wu18@example.com', '2020-12-30', '项目经理', '运营部', 7200.00, TRUE),
       ('己十九', '男', '16400164000', 'ji19@example.com', '2022-05-15', '人事专员', '人事部', 6800.00, TRUE),
       ('庚二十', '女', '16500165000', 'geng20@example.com', '2023-03-05', 'UI设计师', '设计部', 7000.00, TRUE),
       ('辛二十一', '男', '16600166000', 'xin21@example.com', '2018-08-25', '系统分析师', '技术部', 6500.00, FALSE),
       ('壬二十二', '女', '16700167000', 'ren22@example.com', '2020-01-05', '行政助理', '行政部', 5000.00, TRUE),
       ('癸二十三', '男', '16800168000', 'gui23@example.com', '2021-09-15', '产品经理', '产品部', 7200.00, FALSE),
       ('甲二十四', '女', '16900169000', 'jia24@example.com', '2019-02-18', 'UI设计师', '设计部', 7000.00, TRUE),
       ('乙二十五', '男', '17000170000', 'yi25@example.com', '2017-11-01', '项目经理', '运营部', 7500.00, FALSE);