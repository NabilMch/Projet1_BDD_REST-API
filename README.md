# Descriptif:
 Ce projet permet de recupérer depuis l'API du Skyscanner les  vols avec le prix, les dates, l'aeroport de depart, aeroport_arrivee puis recuperer la meteo depuis l'api    WeatherAPI.com afin de bien choisir le jour du vol 
 
 ![image](https://user-images.githubusercontent.com/58047611/122482551-13aab080-cfd1-11eb-9d92-53408c2ad428.png)


 ## Outils:
 
 ### Les apis utilisé:
 - Skyscanner Flight Search
 - WeatherAPI.com
 ### Language et Base de données:
 - JAVA
 - MySql

## Etape1:
Connecter a la base de données:

```java
#DataBase
spring.datasource.url=jdbc:mysql://database-2.clqyelesxcmd.eu-west-3.rds.amazonaws.com:3306/nabil_base
spring.datasource.username=admin
spring.datasource.password=admin2020
spring.jpa.hibernate.ddl-auto=validate
```
## Etape2:
Connecter au API:
### FlightsAPI
```java
flights.api.endpoint=https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com
flights.api.key=******************************
flights.api.host=skyscanner-skyscanner-flight-search-v1.p.rapidapi.com
flights.days.interval=15
```

### WeatherAPI
```java
weathers.api.endpoint=https://weatherapi-com.p.rapidapi.com
weathers.api.key=******************************
weathers.api.host=weatherapi-com.p.rapidapi.com
weathers.days.interval=15
```

# Lien:
https://rapidapi.com/weatherapi/api/weatherapi-com/

https://rapidapi.com/skyscanner/api/skyscanner-flight-search/


