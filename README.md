# Lotus BookStore
## Team Members
* Xinqi Cheng
* Yang Zhou
* Chengxiang Gong

## Link to our website
http://ec2-3-96-57-51.ca-central-1.compute.amazonaws.com:8080/index.jsp. 

## Description
It is the website we made and use for demo, if there is any question of this website please contact any of our group members for help.

The zip (downloaded from Github) contains our SQL file

## How to use:
* Database

The database we are using is `MySQL`

Username
```
root
```
Password
```
root
```
Default port number
```
3306
```

!!! Instruction: First put sql file in to MySQL, and then put the bookstore.war file under webapps, and then startup the Tomcat, visit website http://127.0.0.1:8080/bookstore/ (depend on your tomcat setting)


* Dependency
We are using Maven to manage dependencies
The link to our [pom.xml](https://github.com/Tnni/BookStore-Website/blob/master/pom.xml)

Dependency list
```
    activation-1.1.jar
    aopalliance-repackaged-2.4.0-b10.jar
    c3p0-0.9.5.2.jar
    hk2-api-2.4.0-b10.jar
    hk2-locator-2.4.0-b10.jar
    hk2-utils-2.4.0-b10.jar
    jackson-annotations-2.3.2.jar
    jackson-core-2.3.2.jar
    jackson-databind-2.3.2.jar
    jackson-jaxrs-base-2.3.2.jar
    jackson-jaxrs-json-provider-2.3.2.jar
    jackson-module-jaxb-annotations-2.3.2.jar
    javaee-api-7.0.jar
    javassist-3.18.1-GA.jar
    javax.annotation-api-1.2.jar
    javax.inject-2.4.0-b10.jar
    javax.mail-1.5.0.jar
    javax.ws.rs-api-2.0.1.jar
    jersey-client-2.17.jar
    jersey-common-2.17.jar
    jersey-container-servlet-2.17.jar
    jersey-container-servlet-core-2.17.jar
    jersey-entity-filtering-2.17.jar
    jersey-guava-2.17.jar
    jersey-media-jaxb-2.17.jar
    jersey-media-json-jackson-2.17.jar
    jersey-server-2.17.jar
    jsp-api-2.1.jar
    jstl-api-1.2.jar
    mchange-commons-java-0.2.11.jar
    mysql-connector-java-5.1.36.jar
    osgi-resource-locator-1.0.1.jar
    servlet-api-2.5.jar
    standard-1.1.2.jar
    validation-api-1.1.0.Final.jar
 ```
### Note:
Our jsp files are in: webapp/WEB-INF/template

Our souce file are in: src/kp <----our team name
