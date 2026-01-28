# Práctica de Spring Boot inyección de dependencia

Es vital no instanciar el servicio con la palabra new, sino permitir que Spring lo inyecte, asegurando así que todas las capas de la aplicación estén correctamente conectadas y gestionadas por el contenedor de inversión de control, como lo veremos a continuación. Para realizar la inyección de dependencia utilizamos la notación @Autowired es una anotación fundamental en Spring Framework que permite la inyección de dependencias automática. Spring busca beans (objetos gestionados) en su contenedor y los asigna automáticamente a los campos, constructores o métodos setter, eliminando la necesidad de crear objetos manualmente.
private ProductoRepositoryImpl repository = new ProductoRepositoryImpl(); 
En lugar de crear una nueva instancia con el operador new, es decir en lugar de que nosotros llamemos al objeto (repository), el contenedor nos llama a nosotros y nos provee el objeto, principio Hollywood. Y simplemente anotamos con @Autowired haciendo referencia a la clase de la interfaz IProductoRepository, por atributo.
@Autowired
private IProductoRepository repository;

## 🧩 Arquitectura basada en Meta-anotaciones

Una de las características más potentes de este proyecto es el uso de **Meta-anotaciones** de Spring Framework. En Spring, las anotaciones de "estereotipo" no son elementos aislados, sino que heredan capacidades de una anotación base llamada `@Component`.

### ¿Qué es una Meta-anotación?
Es una anotación que se aplica sobre otra anotación. Esto permite crear una jerarquía de componentes donde cada uno hereda el comportamiento de detección automática (Component Scanning) pero añade una especialización semántica y funcional:

| Anotación | Meta-anotación base | Especialización |
| :--- | :--- | :--- |
| **`@Repository`** | `@Component` | Añade traducción automática de excepciones de persistencia. |
| **`@Service`** | `@Component` | Define la capa de lógica de negocio (Business Logic). |
| **`@RestController`**| `@Controller` + `@ResponseBody` | Gestiona peticiones HTTP y serializa la respuesta a JSON. |



### Ventajas de este enfoque:
1. **Semántica Clara:** Facilita la lectura del código al identificar inmediatamente el rol de la clase.
2. **Aspectos Técnicos:** Spring puede aplicar comportamientos específicos (como gestión de transacciones en Servicios o seguridad en Controladores) basándose en estas marcas.
3. **Escalabilidad:** Permite separar las responsabilidades siguiendo los principios **SOLID**, facilitando el mantenimiento y las pruebas unitarias.

No solamente podemos inyectar mediante el atributo, sino también mediante constructor o también mediante método setter, ¿pero cual es recomendable?.
Aunque las tres formas funcionan, el equipo de Spring y la comunidad de desarrolladores profesionales recomiendan encarecidamente la inyección por constructor.

1. Inyección por Constructor (La Recomendada) 🏆
Es la que usas cuando declaras tus atributos como private final.

Inmutabilidad: Al usar final, garantizas que la dependencia no cambie una vez que el objeto ha sido creado. Esto es vital para la seguridad del hilo (thread-safety).

Contratos Claros: No puedes crear el objeto si falta una pieza. Si intentas hacer un new manual en una prueba unitaria, el compilador te obligará a pasarle las dependencias.

Adiós a @Autowired: En versiones modernas de Spring, si solo tienes un constructor, ya no necesitas poner la anotación @Autowired encima; Spring lo entiende automáticamente.

2. Inyección por Atributo (Field Injection)
Es cuando pones el @Autowired directamente sobre la variable: @Autowired private MiServicio servicio;.

Por qué NO usarla: Es muy cómoda de escribir, pero hace que tu clase sea "esclava" de Spring. Si quieres probar esa clase fuera de Spring (en un Test unitario puro), es muy difícil inyectarle una dependencia falsa (Mock) porque el atributo es privado y no hay constructor ni setter. Además, permite que la clase crezca demasiado (puedes tener 20 atributos con @Autowired y no notarás que tu clase tiene demasiadas responsabilidades).

3. Inyección por Setter
Se usa poniendo el @Autowired sobre un método setAlgo().

Cuándo usarla: Es ideal para dependencias opcionales. Si tu clase puede funcionar perfectamente sin esa pieza, o si necesitas cambiar la dependencia en tiempo de ejecución (algo poco común), el setter es el camino.

Aunque Spring ofrece flexibilidad en la forma de inyectar dependencias, la inyección por constructor se ha consolidado como la práctica estándar en la industria. Al promover la inmutabilidad de los componentes y facilitar las pruebas unitarias sin depender del contenedor de Spring, garantiza una arquitectura más robusta y menos propensa a errores de puntero nulo (NullPointerException) durante la inicialización."
