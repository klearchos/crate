This project has been used for demonstration purposes during a Java meetup at Thessaloniki (https://www.meetup.com/Thessaloniki-Java-Meetup-Group/events/240809028/)

The raspberry pi sends some data from the temperature/humidity sensor (https://www.adafruit.com/product/393) using 
Python. 

The data would then be ingested to CrateDB through the Spring application. Finally we visualise the data with the 
help of the Grafana project (https://grafana.com/).

Under a real environment there would be a load balancer in front of the applications. Each application would connect 
directly with a CrateDB.

 
