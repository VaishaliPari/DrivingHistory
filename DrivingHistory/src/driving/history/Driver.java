package driving.history;

public class Driver {
	
	private final String name;
	private double miles;
	private int speed;
	private int time;
	
	public Driver(String name){
		this.name=name;
		miles=0;
		time=0;
		speed=0;
	}

	public String getName() {
		return name;
	}

	public double getMiles() {
		return miles;
	}

	public int getTime() {
		return time;
	}

	public int getSpeed() {
		return speed;
	}
	
	public void setMiles(double n){
		miles=n;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	
	/**
	 * Calculate the average speed of the driver
	 */
	public void speedCalc(){
		double s=(miles*60)/time;
		setSpeed((int) Math.round(s));
	}
}
