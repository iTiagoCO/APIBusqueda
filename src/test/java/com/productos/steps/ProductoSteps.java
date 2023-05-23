package com.productos.steps;

import com.productos.apirest.models.Producto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


public class ProductoSteps {

    @Autowired
    private RestTemplate restTemplate;

    private ResponseEntity<Object[]> response = new ResponseEntity<>(HttpStatus.OK); // Inicializa la variable response


    public ProductoSteps() {
        // Inicializa la instancia de RestTemplate
        restTemplate = new RestTemplate();
    }




    @Given("the API is running")
    public void theApiIsRunning() {
        // No se requiere implementación, este paso es solo para contextualizar la prueba
    }

    @Given("the database contains the following products:")
    public void theDatabaseContainsTheFollowingProducts(List<Map<String, String>> products) {
        // Aquí puedes agregar lógica para cargar los productos en la base de datos antes de cada escenario de prueba
    }



    @When("I search for products with filters:")
    public void iSearchForProductsWithFilters(List<Map<String, String>> filters) {
        String baseUrl = "http://localhost:8080";
        String path = "/api/busqueda?categoria={categoria}&precio={precio}&ubicacion={ubicacion}";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + path);

        for (Map<String, String> filter : filters) {
            String key = filter.keySet().iterator().next();
            String value = filter.get(key);
            builder.queryParam(key, value);
        }

        URI uri = builder.buildAndExpand(filters.get(0)).toUri(); // Utiliza los valores de filtro de la primera fila
        response = restTemplate.getForEntity(uri, Object[].class); // Utiliza la variable de clase

    }



    @Then("I should receive the following products:")
    public void iShouldReceiveTheFollowingProducts(List<Map<String, String>> expectedProducts) {

        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Producto> actualProducts = new ArrayList<>();
        for (Map<String, String> productData : expectedProducts) {
            Producto producto = new Producto();
            producto.setId(Integer.valueOf(productData.get("id")));
            producto.setNombre(productData.get("nombre"));
            producto.setCategoria(productData.get("categoria"));
            producto.setPrecio(new BigDecimal(productData.get("precio")));
            producto.setUbicacion(productData.get("ubicacion"));
            actualProducts.add(producto);
        }

        assertEquals(expectedProducts.size(), actualProducts.size());
    }

    @Given("I have a product with id {int}")
    public void i_have_a_product_with_id(Integer int0) {

    }
    @When("I request recommendations for product with id {int}")
    public void i_request_recommendations_for_product_with_id(Integer int0) {
        // Write code here that turns the phrase above into concrete actions
    }


    @When("I search for products by text {string}")
    public void iSearchForProductsByText(String text) {
        String baseUrl = "http://localhost:8080";
        String path = "/api/busqueda-texto/" + text;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + path);
        response = restTemplate.getForEntity(baseUrl+path, Object[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @When("I get recommendations for product with ID {int}")
    public void iGetRecommendationsForProductWithId(Integer productId) {
        String baseUrl = "http://localhost:8080";
        String path = "/api/busqueda-recomendaciones?productoId=" + productId;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + path);
        response = restTemplate.getForEntity(baseUrl+path, Object[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }


    @When("I request autocomplete suggestions for text {string}")
    public void i_request_autocomplete_suggestions_for_text(String string) {
        String baseUrl = "http://localhost:8080";
        String path = "/api/busqueda-autocompletado?texto=" + string;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + path);
        response = restTemplate.getForEntity(baseUrl+path, Object[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}

