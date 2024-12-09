# Prendi il docker come builder
FROM maven:3.9.9-eclipse-temurin-23-alpine AS builder

# Creazione e spostamento nella cartella dove si builda
WORKDIR /build

# Copia il progetto e fai la build con maven
COPY ./pom.xml ./
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package -DskipTests

# Crea l'immagine a runtime
FROM  openjdk:23-jdk-slim

# Creazione e spostamento nella cartella dove dovrà risiedere il jar
WORKDIR /app

# Sposta il jar dal builder nella attuale cartella del runtime
COPY --from=builder /build/target/dinotodo-0.0.1-SNAPSHOT.jar app-1.0.0.jar

# Esegui il jar copiato all'interno della cartella attuale
CMD ["java", "-jar", "/app/app.jar"]