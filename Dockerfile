FROM openjdk:8-alpine
COPY "./target/pruebaNeoris.war" "app.war"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.war"]