# DrivingHistory
simple code to track driving history for people

### OBJECT MODELLING

- Driver class has properties such as:
- name: drvier's name
- miles: total miles(all trips) driven by the driver
- time: total time in minutes(all trips) driven by the driver 
- speed: Average speed of driver calculated from total miles and total time

- Trip class has properties such as:
- name: name of the driver taking the trip
- miles: miles covered in this trip
- start: start time of the trip
- end: end time of the trip
- speed: Average speed of the trip

### UNIT TESTING:
- DriverTest class has the unit test for the 'speed calculation' function of Driver
- TripTest class has the unit test for the 'speed calculation' and 'trip time in minutes' functions of Trip

### ASSUMPTIONS:
- We'll use a 24-hour clock (Given)
- Drivers never drive past midnight (Given)
- The start time will always be before the end time (Given)
- When a driver is on a trip, the drivers details can still be used to start a new trip.
Eg: Trip Dan 10:00 12:00 20
	Trip Dan 11:00 12:30 17
	(logically not possible, but here it's possible since case not handled)

### ERROR HANDLING:
- try catch used to catch any syntax errors in the input format
- try catch used to throw error when file not passed as argument

### SPECIAL CASE:
- Trip with speed less than 5mph or over 100mph will be discarded (given)

### INPUT FILE:
- input.txt (Given Example)
- input2.txt :have some cases showing the invalid inputs
- Location: "InputFile/input.txt" and "InputFile/input2.txt"

### Attachment:
-Attaching a graphical example of creation and updating of the object model with an example
