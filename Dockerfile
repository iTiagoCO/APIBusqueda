# Usa una imagen base de Java 8
FROM openjdk:8

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por tu proyecto en el directorio de trabajo del contenedor
COPY target/apirest-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que se ejecuta tu aplicación dentro del contenedor
EXPOSE 8080

# Comando para ejecutar tu aplicación cuando el contenedor se inicie
CMD ["java", "-jar", "app.jar"]
