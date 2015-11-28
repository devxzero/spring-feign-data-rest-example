# spring-feign-data-rest-example
An example showing Spring Feign as a HATEOAS client of Data Rest

This example contains three projects:

* data-rest-service: a Data REST service using an embedded H2 Database, JpaRepository and HATEOAS/HAL (by default).
* feign-client-boot: a Feign REST client configured to understand HATEOAS/HAL. It uses Spring Boot.
* feign-client-nonboot: even though Feign falls under the Spring Cloud umbrella, which in turn falls under Spring Boot,
 the use of Feign is also useful outside Boot, like RestTemplate. This example is a version of feign-client-boot without
 the dependencies on Spring Boot.


## Problem 1: Spring RestTemplate + HATEOAS ==> complicated and ugly
I was trying to get Springs RestTemplate (as a REST client) to work with a REST service. RestTemplate works fine
when using basic JSON (level 2 on the Richardson REST Maturity Model), but when adding hypermedia (level 3) to the 
REST service (which is considered as a good practice) in combination with requests that return a list of results,
the use of RestTemplate is complicated a lot: you suddenly have
to configure the RestTemplate to be able to understand the HAL (Hypertext Application Language) JSON standard convention
followed by the use of classes such as Resource<T>, Resources<T>, PagedResources<T>, followed by a verbose/ugly method call
to perform the request: exchange() method with 4 arguments, of which one is null and of which one is an empty anonymous
class (ParameterizedTypeReference) that is required to give the type parameter to the RestTemplate, otherwise it won't be able to map it back to the 
original class and then thus creates a basic JSON hashmap instead.

## Problem 2: Spring Feign + HATEOAS, scarce information
Information about getting Spring Feign to work with HATEOAS/HAL (which is used by default by Spring Data REST), is
pretty scarce: examples are often without HATEOAS, which makes it difficult to get it to work with Data REST.
People easily run into JSON deserialization problems like [http://stackoverflow.com/questions/30515483/feign-and-hal-resources](http://stackoverflow.com/questions/30515483/feign-and-hal-resources)

> Caused by: com.fasterxml.jackson.databind.JsonMappingException: Can not deserialize instance of java.util.ArrayList out of START_OBJECT token

Fortunately in [https://github.com/joshlong/not-a-last-minute-demo](https://github.com/joshlong/not-a-last-minute-demo) I found a working example of Feign with HATEOAS, on which my example is based.
My example shows a Feign project stripped to the minimum, communicating with a Data REST project.

## Solution using Spring Feign + HATEOAS
See in code.


