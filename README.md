![enter image description here](https://ondemand.bannerbear.com/signedurl/9K5qxXae32jEAGRDkj/image.jpg?modifications=W3sibmFtZSI6InJlcG8iLCJ0ZXh0IjoiaVRpYWdvQ08gLyAqQVBJQnVzcXVlZGEqIn0seyJuYW1lIjoiZGVzYyIsInRleHQiOiIgIn0seyJuYW1lIjoiYXZhdGFyNSIsImhpZGUiOnRydWV9LHsibmFtZSI6ImF2YXRhcjQiLCJoaWRlIjp0cnVlfSx7Im5hbWUiOiJhdmF0YXIzIiwiaGlkZSI6dHJ1ZX0seyJuYW1lIjoiYXZhdGFyMiIsImhpZGUiOnRydWV9LHsibmFtZSI6ImF2YXRhcjEiLCJpbWFnZV91cmwiOiJodHRwczovL2F2YXRhcnMuZ2l0aHVidXNlcmNvbnRlbnQuY29tL3UvNDk5MjMxMjM_dj00In0seyJuYW1lIjoiY29udHJpYnV0b3JzIiwidGV4dCI6ImlUaWFnb0NPIn0seyJuYW1lIjoic3RhcnMiLCJ0ZXh0IjoiMCJ9XQ&s=cc0d309575b458a20f75a9f04ec630ea44326764d7fc5e79b8a636c53fe4e9bf)

## **Servicios de búsqueda y filtrado de productos**
El conjunto de operaciones de este API permite a los usuarios buscar y filtrar productos en una base de datos o sistema utilizando diferentes métodos de búsqueda y criterios de filtrado.
## ✔️ Tecnologias utilizadas

<img alt="Java" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width="50" height="50"/> <img alt="IntelliJ" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="50" height="50"/> <img alt="Spring" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg"  width="50" height="50"/> <img  alt="Cucumber" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/cucumber/cucumber-plain.svg"  width="50" height="50"/>

- ``Java 8``
- ``InteliJ IDEA``
- ``Spring Boot``
- ``Cucumber``
- ``Gherkin``
- ``Maven``

1.  Java - 1.8.x
    
2.  Maven - 3.x.x

El API proporciona las siguientes operaciones:

Búsqueda de productos con filtros: Esta operación permite buscar productos utilizando palabras clave de búsqueda y filtros de categoría, rango de precios, ubicación, etc.

Búsqueda de productos por texto completo: Esta operación permite buscar productos utilizando una consulta de texto completo, como una frase o una pregunta.

Búsqueda de productos por facetas: Esta operación permite buscar productos utilizando una o varias facetas, como categorías, marcas, tamaños, colores, etc.

Recomendaciones de productos relacionados: Esta operación sugiere productos o elementos relacionados o similares al término de búsqueda actual.

Autocompletado de búsqueda de productos: Esta operación proporciona sugerencias de términos de búsqueda y autocompletado mientras el usuario escribe su consulta de búsqueda.

Cada operación utiliza un verbo HTTP y una ruta de operación específica para procesar la solicitud y devolver los resultados correspondientes. Además, el API implementa prácticas recomendadas de seguridad y validación de datos para evitar vulnerabilidades y asegurar la integridad de los datos.

## Catálogo de operaciones del API

 - GET

		{rutaBase}/api//busqueda-texto/{texto}

	Este servicio permite buscar productos en una base de datos o sistema utilizando palabras 		   	clave de búsqueda y filtros de categoría, rango de precios, ubicación, etc. Devuelve una lista de productos que cumplen con los criterios de búsqueda especificados.

	Servicio de búsqueda por facetas

 - GET

		{rutaBase}/api/busqueda-faceta

	Este servicio permite buscar productos en una base de datos o sistema utilizando una o varias facetas, como categorías, tamaños, colores, etc.Devuelve una lista de productos que cumplen con los criterios de búsqueda especificados.

	Servicio de recomendaciones de búsqueda

 - GET

		{rutaBase}/api/busqueda-recomendaciones

	Este servicio permite obtener una lista de productos relacionados al producto buscado, utilizando datos como la categoría a la que pertenece o las subcategorías. Devuelve una lista de productos que no son propiamente el producto buscado pero se relaciona de alguna manera

	Servicio de autocompletado de búsqueda

 - GET

		{rutaBase}/api/busqueda-autocompletado

	Este servicio proporciona sugerencias de términos de búsqueda y autocompletado mientras el usuario escribe su consulta de búsqueda. Devuelve una lista de sugerencias de autocompletado basadas en el historial de búsqueda y la popularidad de los productos.

## Pasos construccion y compilacion

**1. Clone the application**

https://github.com/iTiagoCO/APIBusqueda

**2. Build and run the app using maven**

mvn package
java -jar target/*.jar
mvn spring-boot:run

The app will start running at  [http://localhost:8080](http://localhost:8080/).


Swagger OpenAPI definition
http://localhost:8080/swagger-ui/index.html
