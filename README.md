### projectVoy

 Test Java project
____
### Get started
 clone repository 
```
 git clone https://github.com/aleporyadin/projectVoy.git
```
____
I recommended you use **Intellij idea** \
Open project in Intellij idea \
Next add **configuration Spring Boot** \
Use XAMPP or OpenServer ( to run localhost) \
On PhpMyAdmin create DB - **testvoy** \
And import file in project - **"testvoy.sql"** \
Check file **"application.properties"**
   
# Set up setting DB example 
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/testvoy?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name =com.mysql.jdbc.Driver
#spring.jpa.show-sql: true
```
# Where
 spring.datasource.url  ... testvoy..
 testvoy -> name DB 

 spring.datasource.username=root
 root -> name user DB

 spring.datasource.password=
 "" -> password DB

# Routing
```
localhost:8080/
```
Open index file where  inputs: 
 +  Item         (name product)
 +  price        (price product)
 +  quantity     (count product)  
( **no data validation!**)
Three buttons:
 - Submit        ( redirect user to page **"localhost:8080/result"** where there is information about items and add product to DB) 
 - Go to orders  ( redirect user to page **"localhost:8080/result"** )
 - Search item   ( redirect user to page localhost:8080/search where there is input  search entered product)
 
