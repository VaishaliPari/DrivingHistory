package driving.history;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrivingHistoryCalculate {

	public static void main(String args[]) throws IOException {
		try{
			File file = new File(args[0]);   
			parseInputFile(file);	    
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Pass File as Argument! Exception: "+e);
		} catch(Exception e) {
			System.out.println("Invalid Input! Exception: "+e);
		}
		
	}
	
	/**
	 * This function parses the input and calls the Drive/Trip objects accordingly 
	 * Functions Calculate trip speed and updates driver with trip details are called logically in place
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	public static void parseInputFile(File file) throws FileNotFoundException {
		
		String line;
		HashMap<String, Driver> h=new HashMap<String, Driver>();
		Scanner sc = new Scanner(file);
		
		while (sc.hasNext()) {
        	line=sc.nextLine();
        	String []a=line.split(" ");
        	
        	//adding driver if input string is driver and name
        	if(a.length==2 && (a[0].toLowerCase()).equals("driver")) {
        		Driver d=new Driver(a[1]);
        		h.put(a[1], d);
        	}
        	//adding trip and updating driver with trip details if trip is valid
        	else if(a.length==5 && (a[0].toLowerCase()).equals("trip")) {
        		try{
        			Trip t=new Trip(a[1],a[2],a[3],Double.parseDouble(a[4]));
        			t.speedCalc();
	        		if(t.getSpeed()>100||t.getSpeed()<5){
	        			t=null;
	        			System.out.println("Trip with "+a[1]+" starting: "+a[2]+" ending: "+a[3]+" with distance: "+a[4]+" Discarded due to over speeding/Under speeding");
	        		}
        		
	        		else
	        			updateDriverWithTripDetails(t,h.get(a[1]));
        		} catch(NullPointerException e){
    				System.out.println("Invalid trip details: "+line+" driver not added/found! Exception: "+e);
    			} catch(NumberFormatException e){
        			System.out.println("Invalid trip details: "+line+" Give double value for miles! Exception: "+e);
        		} catch(ArrayIndexOutOfBoundsException e) {
        			System.out.println("Invalid trip details: "+line+" Give valid start/end time! Exception: "+e);
        		}
        	}
        	//Handling invalid inputs
        	else
        		System.out.println("Invalid input line: "+line);
        }
		sc.close();  
		
		Collection<Driver> driverCollection=h.values();
        List<Driver> driverList = new ArrayList<Driver>(driverCollection );
        reportDrivingHistory(driverList);
		
	}
	
	/**
	 * Updating details of Driver d with Trip t
	 * 
	 * @param t - Trip object
	 * @param d - Driver Object
	 */
	public static void updateDriverWithTripDetails(Trip t,Driver d){
		d.setMiles(d.getMiles()+(int)Math.round(t.getMiles()));
		d.setTime(d.getTime()+t.tripTimeInMins());
		d.speedCalc();
	}
	
	/**
	 * print the driving history of drivers, Sorted by most miles driven 
	 * 
	 * @param driverList - a list of driver objects
	 */
	public static void reportDrivingHistory(List<Driver> driverList){
		 while (driverList.isEmpty()==false) {
	        	Driver temp=driverList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Driver::getMiles))).get();
	        	if(temp.getMiles()!=0)
	        		System.out.println(temp.getName()+": "+(int)temp.getMiles()+" miles @ "+temp.getSpeed()+" mph");
	        	else
	        		System.out.println(temp.getName()+": 0 miles");
	        	driverList.remove(temp);
		 }
	}
}
