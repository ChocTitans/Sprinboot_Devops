FROM openjdk:17-jdk
WORKDIR /work/

COPY target/*.jar /work/gstock-0.0.1-SNAPSHOT.jar


EXPOSE 8082
CMD ["java","-jar","gstock-0.0.1-SNAPSHOT.jar"]