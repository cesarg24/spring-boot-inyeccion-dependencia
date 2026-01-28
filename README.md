# Práctica de Spring Boot inyección de dependencia

Es vital no instanciar el servicio con la palabra new, sino permitir que Spring lo inyecte, asegurando así que todas las capas de la aplicación estén correctamente conectadas y gestionadas por el contenedor de inversión de control, como lo veremos a continuación. Para realizar la inyección de dependencia utilizamos la notación @Autowired es una anotación fundamental en Spring Framework que permite la inyección de dependencias automática. Spring busca beans (objetos gestionados) en su contenedor y los asigna automáticamente a los campos, constructores o métodos setter, eliminando la necesidad de crear objetos manualmente.
private ProductoRepositoryImpl repository = new ProductoRepositoryImpl(); 
En lugar de crear una nueva instancia con el operador new, es decir en lugar de que nosotros llamemos al objeto (repository), el contenedor nos llama a nosotros y nos provee el objeto, principio Hollywood. Y simplemente anotamos con @Autowired haciendo referencia a la clase de la interfaz IProductoRepository.
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
