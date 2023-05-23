package com.productos.apirest.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import com.productos.apirest.models.Producto;
import com.productos.apirest.repository.ProductoRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST que permite a los usuarios buscar y filtrar productos en una base de datos o sistema utilizando diferentes métodos de búsqueda y criterios de filtrado",
		tags = "Servicios de búsqueda y filtrado de productos")
@CrossOrigin(origins = "*") //Libera todos los dominios de acceso
public class ProductoController {

	@Autowired
	ProductoRepository productoRepository;

	@ApiOperation(value = "Búsqueda de productos con filtros", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Búsqueda válida"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el servidor mientras se procesaba la solicitud.")
	})
	@GetMapping(value = "/busqueda", produces = "application/json")
	public List<Producto> buscarProductosConFiltros(@RequestParam(required = false) String categoria,
													@RequestParam(required = false) BigDecimal precio,
													@RequestParam(required = false) String ubicacion) {
		return productoRepository.findByCategoriaAndPrecioGreaterThanEqualAndUbicacion(categoria, precio, ubicacion);
	}

	@ApiOperation(value = "Búsqueda de productos por texto", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Búsqueda válida"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el servidor mientras se procesaba la solicitud.")
	})
	@GetMapping("/busqueda-texto/{texto}")
	public List<Producto> buscarProductosPorTexto(@PathVariable String texto) {
		return productoRepository.findByNombreContaining(texto);
	}

	@GetMapping("/busqueda-recomendaciones")
	@ApiOperation(value = "Servicio de recomendaciones de búsqueda", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Búsqueda válida"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el servidor mientras se procesaba la solicitud.")
	})
	public List<Producto> obtenerRecomendacionesDeBusqueda(@RequestParam Integer productoId) {
		Producto producto = productoRepository.findById(productoId).orElse(null);
		if (producto == null) {
			// Manejar el caso en que no se encuentre el producto con el ID proporcionado
			return new ArrayList<>();
		}
		List<Producto> productosRelacionados = productoRepository.findByCategoria(producto.getCategoria());
		productosRelacionados.removeIf(p -> p.getId() == producto.getId()); // Eliminar el producto actual de la lista de recomendaciones
		return productosRelacionados;
	}


	@GetMapping("/busqueda-autocompletado")
	@ApiOperation(value = "Servicio de autocompletado de búsqueda", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Búsqueda válida"),
			@ApiResponse(code = 500, message = "Se ha producido un error interno en el servidor mientras se procesaba la solicitud.")
	})
	public List<String> obtenerSugerenciasDeAutocompletado(@RequestParam String texto) {
		return productoRepository.findAutocompleteSuggestions(texto);
	}



}



