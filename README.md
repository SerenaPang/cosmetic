# cosmetic

This is the web app for the cosmetic app.


## How to build and run

```
mvn clean
mvn spring-boot:run
```

#check all process:
ps -fea | grep java

kill the process:
kill -9 22317

ps -fea | grep spring-boot | grep RELEASE | cut -d' ' -f 4 | xargs kill -9


#How to go to the home page

http://localhost:8080/home

## How to get the template

The template can be obtained from:

- https://start.spring.io/

