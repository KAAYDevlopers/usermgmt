FROM amazoncorretto:17
COPY target/*.jar user-mgmt-0.0.1.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "user-mgmt-0.0.1.jar"]
