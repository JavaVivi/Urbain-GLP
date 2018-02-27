package processing;



/**
 * The chronometer class is composed of the three cyclic counters. We can count until 23 hours 59 minutes and 59
 * seconds.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class Chronometer {
	private CyclicCounter hour = new CyclicCounter(0, 23, 0);
	private CyclicCounter minute = new CyclicCounter(0, 59, 0);

	public void increment() {
			minute.increment();
			if (minute.getValue() == 0) {
				hour.increment();
			}

	}

	public void decrement() {
			minute.decrement();
			if (minute.getValue() == 59) {
				hour.decrement();
			}
	}

	public CyclicCounter getHour() {
		return hour;
	}

	public CyclicCounter getMinute() {
		return minute;
	}


	public String toString() {
		return hour.toString() + " : " + minute.toString();
	}
	
	public static String transform(int value) {
		String result = "";
		if (value < 10) {
			result = "0" + value;
		} else {
			result = String.valueOf(value);
		}
		return result;
	}

	public void init() {
		hour.setValue(0);
		minute.setValue(0);
	}


}
