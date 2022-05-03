## Usuarios by default
- name: admin; password: 1234
- name: user; password: 1234

## Como probar en postman
### Obtener el token
Hacer un post al endpoint /login con los valores de "username" y "password" de un usuario guardado en la bbdd
![login in postman example](/home/sjo/IdeaProjects/springBootApiEcuadorianFoodV2/src/main/resources/images/login.png)
Te devolverá un json con un token.

### Usar el token en los endpoints
Colocar el endpoint en el Header de la peticion al realiar un GET en un endpoint
![food endpoint request with a token](/home/sjo/IdeaProjects/springBootApiEcuadorianFoodV2/src/main/resources/images/food.png)
  
## V3: oauth2 con github
https://spring.io/guides/tutorials/spring-boot-oauth2/
https://www.youtube.com/watch?v=oRolZljP7kc