FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/hw2-0.0.1-SNAPSHOT.jar hw2.jar
ENTRYPOINT ["java", "-jar", "hw2.jar"]
