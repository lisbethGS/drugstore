FROM gradle:4.10.0-jdk8-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

FROM openjdk:8-jdk-alpine
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/drugstore-0.0.1.jar
ENTRYPOINT ["java","-jar","/app/drugstore-0.0.1.jar"]