package com.productos.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductoSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<Object[]> response;

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
        String url = "/api/busqueda";
        String queryString = "?";
        for (Map<String, String> filter : filters) {
            String key = filter.keySet().iterator().next();
            String value = filter.get(key);
            queryString += key + "=" + value + "&";
        }
        response = restTemplate.getForEntity(url + queryString, Object[].class);
    }

    @Then("I should receive the following products:")
    public void iShouldReceiveTheFollowingProducts(List<Map<String, String>> expectedProducts) {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Object[] responseBody = response.getBody();
        List<Object> actualProducts = Arrays.asList(responseBody);
        assertEquals(expectedProducts.size(), actualProducts.size());
        for (int i = 0; i < expectedProducts.size(); i++) {
            Map<String, String> expectedProduct = expectedProducts.get(i);
            Map<String, String> actualProduct = (Map<String, String>) actualProducts.get(i);
            assertEquals(expectedProduct.get("nombre"), actualProduct.get("nombre"));
            assertEquals(expectedProduct.get("categoria"), actualProduct.get("categoria"));
            // Asegúrate de comparar todos los campos necesarios
        }
    }

    @When("I search for products by text {string}")
    public void iSearchForProductsByText(String text) {
        String url = "/api/busqueda-texto/" + text;
        response = restTemplate.getForEntity(url, Object[].class);
    }

    @When("I get recommendations for product with ID {int}")
    public void iGetRecommendationsForProductWithId(Integer productId) {
        String url = "/api/busqueda-recomendaciones?productoId=" + productId;
        response = restTemplate.getForEntity(url, Object[].class);
    }

    @When("I get autocomplete suggestions for text {string}")
    public void iGetAutocompleteSuggestionsForText(String text) {
        String url = "/api/busqueda-autocompletado?texto=" + text;
        response = restTemplate.getForEntity(url, Object[].class);
    }

    // Implementa los demás pasos de prueba (buscar por texto, recomendaciones, autocompletado) de manera similar

}

