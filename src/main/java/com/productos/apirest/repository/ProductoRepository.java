package com.productos.apirest.repository;

import com.productos.apirest.models.Producto;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	List<Producto> findByCategoriaAndPrecioGreaterThanEqualAndUbicacion(String categoria, BigDecimal precio, String ubicacion);
	List<Producto> findByNombreContaining(String texto);
	List<Producto> findByCategoria(String categoria);
	Optional<Producto> findById(Integer id);


	@Query(value = "SELECT nombre FROM producto WHERE nombre LIKE %:texto%", nativeQuery = true)
	List<String> findAutocompleteSuggestions(@Param("texto") String texto);
}
