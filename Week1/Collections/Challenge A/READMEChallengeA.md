# ArrayList vs LinkedList

Para este challenge se usó una instancia de cada uno de estos tipos de colección, cada una
se llenó con 10000000 datos aleatorios de tipo **Integer**. Todos los tiempos que se dan a 
continuación están en nanosegundos.

### Add a new element

| ArrayList | LinkedList |
| --------- | --------- |
| 139600 | 4700 |

### Remove an element from the middle

| ArrayList | LinkedList |
| --------- | --------- |
| 17918600 | 92933800 |

### Insert in the middle a new element

| ArrayList | LinkedList |
| --------- | --------- |
| 19633000 | 112620200 |

### Iterate over the whole collection

| ArrayList | LinkedList |
| --------- | --------- |
| 76614700 | 314612600 |

### Sorting the collection

| ArrayList | LinkedList |
| --------- | --------- |
| 14836137000 | 17814009400 |

## Conclusiones

Personalmente se me hacen extraños los resultados que obtuve pues según la documentación
**LinkedList** siempre tiene un mejor rendimiento en tiempo en las acciones de añadir y 
borrar elementos ya que el **ArrayList** para llevar a cabo estas operaciones tiene que crear
una copia del arreglo y ahí si añadir el nuevo elemento. Pero en este caso probé más de una 
vez y siempre se mantuvo el patrón de que solamente cuando se añade un elemento de formal 
básica el **LinkedList** es mejor. En el resto de casos **ArrayList** es significativamente
mejor.
