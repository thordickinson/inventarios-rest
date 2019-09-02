@echo off
docker-compose down
call ./mvnw -DskipTests clean package
docker-compose up -d
pause
