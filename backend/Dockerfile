FROM openjdk:12

ADD target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 8089

COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

ENTRYPOINT ["./wait-for-it.sh", "mysql-db:3306", "-t", "20", "--", "java", "-Dspring.profiles.active=dockerembbed", "-jar", "demo-0.0.1-SNAPSHOT.jar"]