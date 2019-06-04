# HashMap vs TreeMap

Para este challenge se usó una instancia de cada uno de estos tipos de colección, cada una
se llenó con 10000000 datos aleatorios de tipo **Integer** y sus respectivas claves son del 
mismo tipo. Todos los tiempos que se dan a continuación están en nanosegundos.

### Put a new element

| HashMap | TreeMap |
| --------- | --------- |
| 2200 | 15000 |

### Find an element by key

| HashMap | TreeMap |
| --------- | --------- |
| 81500 | 756100 |

### Remove an element by key

| HashMap | TreeMap |
| --------- | --------- |
| 46000 | 70200 |

### Iterate over the whole entries

| HashMap | TreeMap |
| --------- | --------- |
| 1986085800 | 1731371800 |

## Conclusiones

En este caso los resultados coinciden lo que dice la documentación en cuanto a que en la mayoría
de los casos **HashMap** es mejor que un **TreeMap**. Para este ejemplo el unico caso en el que 
**TreeMap** fue mejor fue en la iteración, esto a mi parecer se debe a que un **TreeMap** está 
organizado de cierta forma y por esto recorrerlo es más fácil que un **HashMap** que no tiene
orden alguno.
