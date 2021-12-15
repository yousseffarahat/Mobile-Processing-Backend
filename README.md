This is a spring boot example application designed to process mobile numbers and assign their respective Country Codes.

##To Run this app use the following command:
* mvn spring-boot:run

##The app will run on port 8080 by default, and the customer list should be accessible on the following API:
* GET: http://localhost:8080/customers/

##There is also a dockerfile to generate the docker image for this service
please expose port 8080 when running the image as the frontend would send requests to localhost:8080
