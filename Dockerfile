FROM eclipse-temurin:17-jre
WORKDIR /app
COPY build/libs/productservice-*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]