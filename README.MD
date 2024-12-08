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
  mapper-locations: classpath*:mapper/**.xml                # Mapper XML 文件位置
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

（1）创建职员基本信息表：docs/sql/staff_basic_info.sql

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