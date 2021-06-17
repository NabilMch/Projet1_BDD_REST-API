# Descriptif:
 Rechercher les différentes statistiques du __NBA__ (score, nombre de point...) et voir quel sont les articles du __New York Times__ en lien avec la NBA 
 Voir la popularité de la nba dans NT.
 
 # Objectif:
  Recupérer depuis l'API du Skyscanner les différent vols avec le prix, les dates, l'aeroport de depart, aeroport_arrivee   parlant de sport (Article Search API, Most popular API) et de les comparer au données de la NBA.
 
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


