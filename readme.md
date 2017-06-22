#Spring Boot and ![Image of CrateDB](https://crate.io/wp-content/themes/webflow/images/logo-crate.png)


## Spring Boot application inserting data from a raspberry pi to CrateDB 

This project has been used for demonstration purposes during a Java meetup at Thessaloniki (https://www.meetup.com/Thessaloniki-Java-Meetup-Group/events/240809028/)

The raspberry pi sends some data from the temperature/humidity sensor (https://www.adafruit.com/product/393) using 
Python. 

The data would then be ingested to CrateDB through the Spring application. Finally we visualise the data with the 
help of the Grafana project (https://grafana.com/).

Under a real environment there would be a load balancer in front of the applications. Each application would connect 
directly with a CrateDB.

### CrateDB version
The system has been tested with CrateDB version `1.1.5`.
The Docker commands that have been used for the presentation can be found under the `presentation` folder along with 
the presentation material. 

### JPA and CrateDB
Up to version 0.57.0 with the Java client it was possible to use JPA. After that version this is not possible anymore 
(https://github.com/crate/crate-sample-apps/blob/master/java/documentation.md). That is why I used simple JDBC at my 
sample application. 

### Raspberry pi
I have been based on this sample from AdaFruit (https://github.com/adafruit/Adafruit_Python_DHT/blob/master/examples/AdafruitDHT.py) 
in order to send the data rom the sensors to the spring boot application. The code can be found under the 
crate/client folder.

