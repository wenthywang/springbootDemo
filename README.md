# springbootDemo
spring boot 2.0 
restful 接口 demo
运行DemoApplication类即可
测试类放在com.example.hui.rest.RestControllerTest类中

# docker 部署 推送到dockerhost 默认推送到dockerhub 如果不需要推送dockerhub 可在pom配置不推送
clean package -DskipTests -Pdocker -DdockerHost=http://111.230.24.31:2375 -f pom.xml