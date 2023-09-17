# API de Consulta de Precios

Esta es una API de consulta de precios que te permite buscar precios aplicables para productos y marcas específicas en función de la fecha. Utiliza Spring Boot con Spring Web y Spring Data JPA para gestionar los datos de precios.

## Cómo Usar la API

### Endpoint: Obtener Precio

- **URL:** `/getPrice`
- **Método HTTP:** `GET`

#### Parámetros de Solicitud

- `brandId` (Long): ID de la marca del producto.
- `productId` (Long): ID del producto.
- `date` (String): Fecha y hora en el formato "yyyy-MM-dd HH:mm:ss".

#### Ejemplo de Solicitud

```http
GET http://localhost:8087/getPrice?brandId=1&productId=35455&date=2020-07-14%2012:00:00
{
  "brandId": 1,
  "startDate": "2020-06-15T14:00:00.000+00:00",
  "endDate": "2020-12-31T22:59:59.000+00:00",
  "priceList": 4,
  "productId": 35455,
  "priority": 1,
  "price": 38.95,
  "currency": "EUR"
}
