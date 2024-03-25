FROM amazoncorretto:21-alpine3.19

WORKDIR /app
ADD /build/libs/GeoLesson-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
