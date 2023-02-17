FROM maven:3-jdk-17-alpine AS build


# Build Stage
WORKDIR /opt/app

COPY ./ /opt/app

# Docker Build Stage
FROM openjdk:17-jdk-alpine

COPY --from=build /opt/app/target/*.jar app.jar

ENV PORT 8081
EXPOSE $PORT

ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","app.jar"]
