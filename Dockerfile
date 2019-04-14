FROM springci/spring-boot-ci-image:2.0.x

WORKDIR /forex-service

COPY . /forex-service

RUN ./mvnw clean install

RUN cp target/forex-service-*.jar ./forex-service.jar

EXPOSE 80

ENTRYPOINT ["java", "-jar", "forex-service.jar", "&"]