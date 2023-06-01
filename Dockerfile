# Establece la imagen base de Docker
FROM openjdk:8-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY target/*.jar /app/apirest.jar

# Ejecuta la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "apirest.jar"]
