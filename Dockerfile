FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/inventarios-rest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port:80","-Dspring.datasource.url=jdbc:postgresql://${PG_IP:postgres.db}:${PB_PORT:5432}/${PG_DB:postgres}", "-Dspring.datasource.username=${PG_USER:postgres}","-Dspring.datasource.password:inventario","-jar","/app.jar"]
