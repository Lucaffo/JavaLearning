FROM openjdk:23-jdk-slim

# Copia il Jar dell'applicazione
COPY target/dinotodo-0.0.1-SNAPSHOT.jar app.jar

# Imposta il comando per eseguire il JAR e caricare le variabili d'ambiente
CMD ["java", "-jar", "app.jar"]