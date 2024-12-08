# kang-template-starter 

## 1 整合技术栈

### 1.1 Knife4j

（1）📍<span style="color: skyblue;">官方文档：</span> https://doc.xiaominfo.com/docs/quick-start

（2）🔄<span style="color: skyblue;">Maven坐标：</span>

```pom
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-openapi2-spring-boot-starter</artifactId>
    <version>4.4.0</version>
</dependency>
```

（3）📖<span style="color: skyblue;">application.yml配置：</span>

```yml
knife4j:
  enable: true
  openapi:
    title: kang-template-starter 接口文档
    description: kang-template-starter 接口文档
    email: 2969268651@qq.com
    concat: liukang
    url: http://localhost:8080/api/doc.html
    version: v1.0
    group:
      test1:
        group-name: api-group-01
        api-rule: package
        api-rule-resources:
          - com.kang.kangtemplate.controller
```

（4）🌐<span style="color: skyblue;">接口文档访问地址：</span>http://localhost:8080/api/doc.html



### 1.2 Mybatis-Plus

#### 1.2.1 基本配置

（1）📍<span style="color: skyblue;">官方文档：</span> https://doc.xiaominfo.com/docs/quick-start

（2）🔄<span style="color: skyblue;">Maven坐标：</span>

```pom
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.5.9</version>
</dependency>
```

（3）📖<span style="color: skyblue;">application.yml配置：</span>

```yml
mybatis-plus:
  mapper-locations: classpath*:mapper/*.xml                # Mapper XML 文件位置
  type-aliases-package: com.kang.kangtemplate.model       # 实体类的包路径
  configuration:
    map-underscore-to-camel-case: true                     # 开启下划线转驼峰
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl  # 开启 SQL 日志输出
```

（4）Mybatis-Plus 分页插件配置类：

```java
@Configuration
@MapperScan("com.kang.kangtemplate.mapper")
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(
            new PaginationInnerInterceptor(DbType.MYSQL)); 
        // 如果有多数据源可以不配具体类型, 否则都建议配上具体的 DbType
        return interceptor;
    }
}

```

#### 1.2.2 Mybatis-Plus 测试

（1）创建职员基本信息表：

```MySQL
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
```

（2）具体测试见程序











## 附录1 图标

### 常用类别及图标

#### 1. **指示方向/提示**

- 🧭 **导航**：`🧭`
- 📍 **位置**：`📍`
- 🚩 **旗帜**：`🚩`
- ➡️ **箭头**：`➡️` `⬅️` `⬆️` `⬇️`

#### 2. **警告/重要信息**

- ⚠️ **警告**：`⚠️`
- ❗ **注意**：`❗`
- ❓ **疑问**：`❓`
- 🔔 **提醒**：`🔔`

#### 3. **任务/状态**

- ✅ **完成**：`✅`
- ❌ **未完成/错误**：`❌`
- 🔄 **进行中**：`🔄`
- ⏳ **等待**：`⏳`

#### 4. **内容/书写**

- 📖 **文档**：`📖`
- 🖊️ **编辑**：`🖊️`
- 📝 **笔记**：`📝`
- 📚 **书籍**：`📚`

#### 5. **时间/日期**

- 🕒 **时间**：`🕒`
- ⏰ **闹钟**：`⏰`
- 📅 **日历**：`📅`

#### 6. **工具/技术**

- 🛠️ **工具**：`🛠️`
- ⚙️ **设置**：`⚙️`
- 🖥️ **电脑**：`🖥️`
- 💻 **笔记本电脑**：`💻`

#### 7. **社交/交流**

- 💬 **消息**：`💬`
- ✉️ **邮件**：`✉️`
- 📞 **电话**：`📞`
- 🌐 **网络**：`🌐`

#### 8. **其他常用图标**

- 🎯 **目标**：`🎯`
- 🔑 **钥匙**：`🔑`
- 🚀 **启动**：`🚀`
- 🌟 **星标**：`🌟`
- 🔥 **热度**：`🔥`

## 附录2 代码提交格式

> 例子：
>
> `docs`(README.MD):  [1]初始化项目、[2]集成常用配置

| Type       | 含义                         |
| ---------- | ---------------------------- |
| `feat`     | 新功能                       |
| `fix`      | 修复 bug                     |
| `docs`     | 修改文档                     |
| `style`    | 格式（代码格式调整）         |
| `refactor` | 重构代码                     |
| `test`     | 添加测试代码                 |
| `chore`    | 构建流程/工具/依赖更新等杂项 |
| `revert`   | 回滚某次提交                 |