# Assessment

 - To create jars run: 
 ```sh
$ mvn clean install
``` 
 - go to: target/transactions-1.0-SNAPSHOT and give execute permision to application file.
 - run commands like this: 
  ```sh
./application 345 add '{"amount":1.24,"description":"JoesTacos","date":"2018-12-27","user_id":345}'
``` 
No white speces allowed do to shell restrictions 
 - Other option is to run it usign the following command but you need to escape ":
 ```sh
 java -cp ./lib/transactions-1.0-SNAPSHOT.jar:./lib/* mx.payclip.assessment.App 345 add "{\"amount\": 1.23, \"description\": \"Joes Tacos\", \"date\":\"2018-07-01\", \"user_id\": 123}"
``` 
