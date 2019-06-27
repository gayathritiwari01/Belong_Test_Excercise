package jcucumberng.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.IOException;

import org.openqa.selenium.Dimension;

import jcucumberng.api.Configuration;

/**
 * {@code SystemUtil} handles actions relating to the user's machine such as
 * input and output devices.
 * 
 */
public final class SystemUtil {

	private SystemUtil() {
		// No instantiation
	}

	/**
	 * Gets the native resolution of the local machine.
	 * 
	 * @return Dimension - the screen size in WxH (e.g. 1920x1080)
	 */
	public static Dimension getDimension() {
		java.awt.Dimension awtDimension = Toolkit.getDefaultToolkit().getScreenSize();
		short width = (short) awtDimension.getWidth();
		short height = (short) awtDimension.getHeight();
		return new Dimension(width, height);
	}

	/**
	 * Accepts a single key entry. The key is pressed and released immediately.
	 * 
	 * @param key the constant from {@code java.awt.event.KeyEvent}
	 * @throws AWTException
	 * @throws IOException
	 */
	public static void pressKey(int key) throws AWTException, IOException {
		Robot robot = new Robot();
		robot.keyPress(key);
		robot.keyRelease(key);
		int waitTime = Integer.parseInt(Configuration.framework("key.press.wait"));
		int millis = TimeUtil.convertSecsToMillisWithRange(waitTime, 1, 60);
		robot.delay(millis);
	}

	/**
	 * Accepts multiple key entries (e.g. shortcut command). The keys are pressed
	 * simultaneously and released in reverse order.
	 * 
	 * @param keys an array of KeyEvent constants from
	 *             {@code java.awt.event.KeyEvent}, specify keys in order
	 * @throws AWTException
	 * @throws IOException
	 */
	public static void pressKeys(int[] keys) throws AWTException, IOException {
		Robot robot = new Robot();
		for (int ctr = 0; ctr < keys.length; ctr++) {
			robot.keyPress(keys[ctr]); // Press and hold keys
		}
		int waitTime = Integer.parseInt(Configuration.framework("key.press.wait"));
		int millis = TimeUtil.convertSecsToMillisWithRange(waitTime, 1, 60);
		robot.delay(millis);
		for (int ctr = keys.length - 1; ctr > -1; ctr--) {
			robot.keyRelease(keys[ctr]); // Release keys in reverse order
		}
	}

}
