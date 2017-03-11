public class LeapYear {
	/**
	 * Jump if a year is a leap year.
	 * @param: year
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		if (isLeapYear(Integer.parseInt(args[0])) == true) {
			System.out.println(args[0] + " is " + "leap year.");
		} else {
			System.out.println(args[0] + " is not " + "leap year.");
			
		}
	}
}