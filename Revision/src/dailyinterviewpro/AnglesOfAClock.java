package dailyinterviewpro;

/**
 * Given a time in the format of hour and minute, calculate the angle of the
 * hour and minute hand on a clock.
 * 
 * @author Sushil
 *
 */
public class AnglesOfAClock {

	public static void main(String[] args) {

		System.out.println(calcAngle(3.0, 30.0));
		System.out.println(calcAngle(12.0, 30.0));
	}

	/**
	 * The idea is to take 12:00 (h = 12, m = 0) as a reference. Following are
	 * detailed steps. 1) Calculate the angle made by hour hand with respect to
	 * 12:00 in h hours and m minutes. 2) Calculate the angle made by minute hand
	 * with respect to 12:00 in h hours and m minutes. 3) The difference between two
	 * angles is the angle between two hands.
	 * 
	 * How to calculate the two angles with respect to 12:00? The minute hand moves
	 * 360 degree in 60 minute(or 6 degree in one minute) and hour hand moves 360
	 * degree in 12 hours(or 0.5 degree in 1 minute). In h hours and m minutes, the
	 * minute hand would move (h*60 + m)*6 and hour hand would move (h*60 + m)*0.5.
	 * 
	 * @param h
	 * @param m
	 * @return
	 */
	public static int calcAngle(double h, double m) {

		if (h < 0 || m < 0 || h > 12 || m > 60) {
			throw new IllegalArgumentException(" Wrong Input");
		}

		if (h == 12) {
			h = 0;
		}

		if (m == 60) {
			m = 0;
		}

		int hour_angle = (int) ((.5) * (h * 60 + m));
		int minute_anglr = (int) (6 * m);
		int angle = Math.abs(hour_angle - minute_anglr);

		angle = Math.min(angle, 360 - angle);

		return angle;
	}
}
