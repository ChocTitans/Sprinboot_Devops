FROM openjdk:8
WORKDIR /work/

COPY target/*.jar /work/gstock-0.0.1-SNAPSHOT.jar


EXPOSE 8081
CMD ["java","-jar","gstock-0.0.1-SNAPSHOT.jar"]