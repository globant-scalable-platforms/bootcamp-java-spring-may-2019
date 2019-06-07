# Spring Parte 1: Agregando un  Bean y una clase

## Agregando un Bean
##### 1) Conectando Bean
Se conectó un Bean dentro de la clase CustomAccountRepository, un Bean denominado"DataSource", que entregaría
un listado con los Usuarios registrados en una Colección. Ejecutando la función de la clase creada RetrieveUserInformation" 
se validaba si se encontraba el usuario o no dentro de la Colección. En caso de ser encontrado, se visualizaba el usuario y su contraseña en el explorador de Spring.

##### 2) Conectado una Clase 
Se creó una nueva clase, denominada HelloWorld, que extraería los usuarios del Bean creado anteriormente (Bean DataSource)
y se les daba la bienvenida a los usuarios desde el explorador de Spring.

# Spring Parte 2: Game

Se desarrolló un nuevo controlador para el juego y una clase conteniendo su lógica de negocio.
El ejercicio consistía en verificar la permanencia de los datos a pesar de que se instanciaran los objetos con scope
Prototype y SIngleton.  


![Kata2](https://github.com/globant-scalable-platforms/bootcamp-java-spring-may-2019/blob/VictorMartinez_Week2_Bootcam/Week2/VictorMartinez/kata1_kata2/kata2.jpg?raw=true "Kata2 Desarrollo")


