## **Servicios de búsqueda y filtrado de productos**
El conjunto de operaciones de este API permite a los usuarios buscar y filtrar productos en una base de datos o sistema utilizando diferentes métodos de búsqueda y criterios de filtrado.

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
