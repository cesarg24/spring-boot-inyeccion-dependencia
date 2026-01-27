# Práctica de Spring Boot creando las principales capas: repositories, services, controllers y models

Este proyecto es una implementación práctica de una arquitectura limpia en Java utilizando **Spring Boot**. El objetivo es demostrar la separación de responsabilidades y el flujo de datos entre las capas de una aplicación web moderna.

## 🚀 Arquitectura del Proyecto

El proyecto sigue el patrón de diseño por capas:

* **Controller:** Define los endpoints REST y gestiona las peticiones HTTP.
* **Service:** Contiene la lógica de negocio (ej. cálculos de impuestos y transformaciones).
* **Repository:** Simula la persistencia de datos y el acceso a la fuente de información.
* **Model:** Define la estructura de los objetos de negocio.

## 🛠️ Tecnologías Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Maven** (Gestor de dependencias)

## 💡 Conceptos Implementados

1. Repository (Capa de Acceso a Datos): Esta es la encargada de interactuar directamente con la base de datos. Su función es ejecutar operaciones CRUD (Select, Insert, Update, Delete) y gestionar las consultas necesarias para recuperar o persistir información.
2. Service (Capa de Lógica de Negocio): Actúa como intermediario entre los controladores y los repositorios. Aquí se reside la lógica del sistema, permitiendo manipular datos de múltiples repositorios y garantizando que las operaciones se ejecuten de forma segura bajo una misma transacción.
3. Controller (Capa de Presentación/API): Es el punto de entrada de la aplicación. Se encarga de gestionar los métodos handler para recibir las peticiones de los usuarios, procesarlas a través de los servicios y retornar la respuesta adecuada, ya sea mediante una vista dinámica o una representación en formato JSON.
4. Models: Esta capa contiene las entidades y estructuras de datos que representan la información del dominio y que fluyen a través de todas las capas anteriores.
5.  **Streams API:** Procesamiento eficiente de colecciones para aplicar lógica de negocio (IVA del 25%).
6.  **Patrón Singleton:** Servicios y repositorios gestionados como instancias únicas.
