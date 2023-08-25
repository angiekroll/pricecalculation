FROM openjdk:17
COPY build/libs/*.jar price-calculation.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "price-calculation.jar"]