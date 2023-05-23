Feature: Búsqueda y filtrado de productos

  Background:
    Given the API is running
    And the database contains the following products:
      | id | nombre                                 | categoria  | precio   | ubicacion |
      | 0  | Audífonos inalámbricos JBL             | Electronica| 249000   | COL       |
      | 1  | Televisor Samsung 55                   | Electronica| 3000000  | COL       |
      | 2  | Amazon Echo Dot 5th Gen                 | Electronica| 250000   | COL       |
      | 3  | Audífonos inalámbricos Sony              | Electronica| 300000   | COL       |
      | 4  | Parlante JBL Charge 5 portátil          | Electronica| 890000   | COL       |
      | 5  | Apple AirPods Pro (2ª generación)        | Electronica| 1300000  | COL       |
      | 6  | Smart TV LG AI ThinQ 4K 60"             | Electronica| 2000000  | COL       |

  Scenario: Buscar productos con filtros
    When I search for products with filters:
      | categoria   | precio  | ubicacion |
      | Electronica | 3000000  | COL       |
    Then I should receive the following products:
      | id | nombre               |  | categoria   | precio  | ubicacion |
      | 1  | Televisor Samsung 55 |  | Electronica | 3000000 | COL       |

  Scenario: Buscar productos por texto
    When I search for products by text "JBL"
    Then I should receive the following products:
      | id | nombre                         | categoria   | precio | ubicacion |
      | 0  | Audífonos inalámbricos JBL     | Electronica | 249000 | COL       |
      | 4  | Parlante JBL Charge 5 portátil | Electronica | 890000 | COL       |

  Scenario: Obtener recomendaciones de búsqueda
    Given I have a product with id 0
    When I request recommendations for product with id 0
    Then I should receive the following products:
      | id | nombre                            | categoria   | precio  | ubicacion |
      | 1  | Televisor Samsung 55              | Electronica | 3000000 | COL       |
      | 2  | Amazon Echo Dot 5th Gen           | Electronica | 250000  | COL       |
      | 3  | Audífonos inalámbricos Sony       | Electronica | 300000  | COL       |
      | 4  | Parlante JBL Charge 5 portátil    | Electronica | 890000  | COL       |
      | 5  | Apple AirPods Pro (2ª generación) | Electronica | 1300000 | COL       |
      | 6  | Smart TV LG AI ThinQ 4K 60"       | Electronica | 2000000 | COL       |


  Scenario: Obtener sugerencias de autocompletado
    When I request autocomplete suggestions for text "Sa"
    Then I should receive the following products:
      | id | nombre               | categoria   | precio  | ubicacion |
      | 1  | Televisor Samsung 55 | Electronica | 3000000 | COL       |