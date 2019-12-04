   FROM openjdk:8
   ADD target/spring-boot-docker-demo.jar spring-boot-docker-demo.jar
   EXPOSE 8085
   ENTRYPOINT ["java","-jar","spring-boot-docker-demo.jar"]

