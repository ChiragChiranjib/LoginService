## LoginService

The endpoints in the SpringBoot App

1. "/"

2. "/urlInput"
HystrixCommand is applied to the end point with various Hystrix properties 
timeoutInMilliseconds
requestVolumeThreshold
errorThresholdPercentage
sleepWindowInMilliseconds

FallbackMethod for this endpoint directs to Error404.jsp

BulkHead Pattern is also applied with Thread pool properties such as,
coreSize
maxQueueSize

Done for fault tolerance and resilience of the App if at all the endpoint calls any external API while scaling
the Application 

## Database

#Tables
1. Session: SessionId(int) @Pk, userName(String), password(String)
2. UrlResponse: slno(int) @Pk, response(String), URL(String)

#The control flow of the Application

SpringSecurity Authentication layer(Encodes password in bcrypt Encoder with strength(Rounds):12) -> "/" ->
URLPage.jsp -> "/urlInput" This saves the url and response in table url_response -> Display.jsp

#Login Acccounts

The login information is already inserted into the session table in cloud hosted Postgresql server:

1. (1,$2a$12$GVl/fyAf8cpIST6rIh9ga.yRBtqmJUsrv.YoFESgjcmIKcYTIISSa,Chirag)
   
   Username= Chirag, Password= Chirag
   
2. (2,$2a$12$gU.LaJYSQUmwWlg8ylu/hufyXbUpB4gOVoMpvW42huwZLRZpqVbA2,Rahul)

   Username= Rahul, Password= Rahul9000
   
3. (3,$2a$12$rX3OVJBdjwSA8IjLgzTQDu0B/.WHnPiiuKYZKDS/VXnld4LDpmcSO,Admin)

   Username= Admin, Password= root

#Database configuration

spring.datasource.url=jdbc:postgresql://ec2-35-153-114-74.compute-1.amazonaws.com:5432/d5uv9vbl53m5qg
spring.datasource.username=$USERNAME
spring.datasource.password=$PASSWORD
spring.jpa.hibernate.show-sql=true
spring.jpa.hibernate.ddl-auto=update

$USERNAME and $PASSWORD are environment variables given as a key value pair in heroku according 
to the database credentials given in heroku
