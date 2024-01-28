## Fase de build
#FROM maven:3.8.4 AS build
#
#RUN mkdir "app"
#WORKDIR /app
#
## Copie o arquivo pom.xml para o diretório de trabalho
#COPY pom.xml .
#
## Baixe as dependências do Maven
#RUN mvn dependency:go-offline
#
## Copie o código-fonte para o diretório de trabalho
#COPY src src
#COPY wait-for-it.sh /wait-for-it.sh
#RUN chmod +x /wait-for-it.sh
## Compile o código-fonte e crie o arquivo JAR
#RUN mvn clean package
#
## Fase de execução
#FROM eclipse-temurin:17-jdk-alpine
#
## Defina o diretório de trabalho como /app
#WORKDIR /app
#
## Copie o arquivo JAR da fase de build para o diretório /app
#COPY --from=build /app/target/*.jar /app/sua-aplicacao.jar
#
## Exponha a porta 8080 (ou a porta que a sua aplicação Spring Boot está configurada para usar)
#EXPOSE 8080
#
## Comando para executar a aplicação quando o contêiner for iniciado
#CMD ["java", "-jar", "sua-aplicacao.jar"]


#FROM openjdk:17-jdk-slim
#
#RUN mkdir "app"
#
#WORKDIR /app
#
#ARG JAR_FILE
#
#COPY target/${JAR_FILE} /app/api.jar
#COPY wait-for-it.sh /wait-for-it.sh
#
#RUN chmod +x /wait-for-it.sh
#
#EXPOSE 8080
#
#CMD ["java", "-jar", "api.jar"]


# Use an official Maven image as the base image
FROM maven:3.9.0 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/funcionario-api.jar .
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
EXPOSE 8080
# Set the command to run the application
CMD ["java", "-jar", "funcionario-api.jar"]