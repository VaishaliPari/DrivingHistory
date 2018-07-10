package driving.history;

public class Trip {
	
	private final String name;
	private final String start;
	private final String end;
	private final double miles;
	private int speed;
	
	public Trip(String name, String start, String end, double miles){
		this.name=name;
		this.start=start;
		this.end=end;
		this.miles=miles;
		setSpeed(0);
	}

	public String getName() {
		return name;
	}

	public double getMiles() {
		return miles;
	}

	public int getSpeed() {
		return speed;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Calculate the trip time in minutes, from the start and end time
	 * 
	 * @return trip time
	 */
	public int tripTimeInMins() {
		int hours = Integer.parseInt(start.split(":")[0]);
		int mins = Integer.parseInt(start.split(":")[1]);
		int startTime=(hours*60)+mins;
		int ehours = Integer.parseInt(end.split(":")[0]);
		int emins = Integer.parseInt(end.split(":")[1]);
		int endTime=(ehours*60)+emins;
		int triptime=endTime-startTime;
		return triptime;
	}
	
	/**
	 * Calculate the trip speed
	 * 
	 * @return speed
	 */
	public int speedCalc() {
		double s=(miles*60)/tripTimeInMins();
		setSpeed((int) Math.round(s));
		return speed;
	}
	
}
