package jcucumberng.utils;

/**
 * {@code TimeUtil} handles actions for manipulating time.
 * 
 */
public final class TimeUtil {

	private TimeUtil() {
		// No instantiation
	}

	/**
	 * Converts seconds to millis with specified range. Defaults to given
	 * {@code begin} or {@code end} if {@code waitTime} is less than or greater than
	 * respectively.
	 * 
	 * @param waitTime value in seconds
	 * @param begin    lowerbound value of the range in seconds, inclusive
	 * @param end      upperbound value of the range in seconds, inclusive
	 * @return int - value in millis
	 */
	public static int convertSecsToMillisWithRange(int waitTime, int begin, int end) {
		if (waitTime < begin) {
			waitTime = begin;
		}
		if (waitTime > end) {
			waitTime = end;
		}
		return waitTime * 1000;
	}

}
