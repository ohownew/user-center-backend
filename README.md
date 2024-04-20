需要在src.main.resources目录下新建一个`application-prod.yml`配置文件

```yaml
# application.yml
spring:
  # DataSource Config
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://[ip:port]/user_center
    username: [username]
    password: [password]
  # 失效时间
  session:
    timeout: 86400
server:
  port: 8080
```

打包完后，通过命令`java -jar .\user-center-0.0.1-SNAPSHOT.jar --spring.profiles.active=prov`启动