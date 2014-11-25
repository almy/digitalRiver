# Perfect Number
is a positive integer that is equal to the sum of its proper positive divisors, that is,
the sum of its positive divisors excluding the number itself.

## Running
***The application is a maven based project and uses Java version 1.7 or higher***
#### mvn clean package && java -jar target/digital.river-1.0-SNAPSHOT.jar

## Unit test and integration test
### mvn integration-test

###if maven is not available
####java -jar target/digital.river-1.0-SNAPSHOT.jar

The microservice accepts http calls for two exposed api defined contract.
1.  One is finding whether the given number is a perfect number
2.  Given a range of numbers start - end returns the perfect numbers found within that range


