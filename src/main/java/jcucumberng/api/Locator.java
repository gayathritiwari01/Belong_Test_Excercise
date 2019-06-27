package jcucumberng.api;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * {@code Locator} handles actions for instantiating the Selenium {@code By}
 * object.
 *
 */
public final class Locator {

	public enum ByMethod {
		ID, NAME, LINK_TEXT, PARTIAL_LINK_TEXT, TAG, CLASS, CSS, XPATH, BY_ALL, BY_CHAINED, BY_ID_OR_NAME, BINDING,
		MODEL, BUTTON_TEXT, CSS_CONTAINING_TEXT, EXACT_BINDING, EXACT_REPEATER, OPTIONS, PARTIAL_BUTTON_TEXT, REPEATER
	}

	private Locator() {
		// No instantiation
	}

	/**
	 * Gets the Selenium {@code By} object.
	 * 
	 * @param key the key from {@code ui-map.properties}
	 * @return By - the {@code By} object
	 * @throws IOException
	 */
	public static By getInstance(String key) throws IOException {
		String locator = null;
		String selector = null;
		String text = null;
		String[] keys = null;
		By[] bys = null;
		Selenium selenium = new Selenium();

		String value = Configuration.uiMap(key);
		if (!value.matches(".+:.+")) {
			throw new IllegalArgumentException("Invalid pattern syntax in ui-map.properties: " + value);
		}

		locator = StringUtils.substringBefore(value, ":");

		selector = StringUtils.substringAfter(value, ":");
		if (StringUtils.contains(selector, "|")) {
			if (StringUtils.containsIgnoreCase(value, ByMethod.BY_ALL.toString())) {
				keys = StringUtils.split(StringUtils.substringAfter(value, ":"), "|");
				bys = selenium.getBys(keys);
				selector = null;
			}
			if (StringUtils.containsIgnoreCase(value, ByMethod.BY_CHAINED.toString())) {
				keys = StringUtils.split(StringUtils.substringAfter(value, ":"), "|");
				bys = selenium.getBys(keys);
				selector = null;
			}
			if (StringUtils.containsIgnoreCase(value, ByMethod.CSS_CONTAINING_TEXT.toString())) {
				text = StringUtils.substringAfter(selector, "|");
				selector = StringUtils.substringBefore(selector, "|");
			}
		}

		By by = null;
		try {
			ByMethod byMethod = ByMethod.valueOf(StringUtils.upperCase(locator));
			switch (byMethod) {
			case ID:
				by = By.id(selector);
				break;
			case NAME:
				by = By.name(selector);
				break;
			case LINK_TEXT:
				by = By.linkText(selector);
				break;
			case PARTIAL_LINK_TEXT:
				by = By.partialLinkText(selector);
				break;
			case TAG:
				by = By.tagName(selector);
				break;
			case CLASS:
				by = By.className(selector);
				break;
			case CSS:
				by = By.cssSelector(selector);
				break;
			case XPATH:
				by = By.xpath(selector);
				break;
			case BY_ALL:
				by = new ByAll(bys);
				break;
			case BY_CHAINED:
				by = new ByChained(bys);
				break;
			case BY_ID_OR_NAME:
				by = new ByIdOrName(selector);
				break;
			case BINDING:
				by = ByAngular.binding(selector);
				break;
			case MODEL:
				by = ByAngular.model(selector);
				break;
			case BUTTON_TEXT:
				by = ByAngular.buttonText(selector);
				break;
			case CSS_CONTAINING_TEXT:
				by = ByAngular.cssContainingText(selector, text);
				break;
			case EXACT_BINDING:
				by = ByAngular.exactBinding(selector);
				break;
			case EXACT_REPEATER:
				by = ByAngular.exactRepeater(selector);
				break;
			case OPTIONS:
				by = ByAngular.options(selector);
				break;
			case PARTIAL_BUTTON_TEXT:
				by = ByAngular.partialButtonText(selector);
				break;
			case REPEATER:
				by = ByAngular.repeater(selector);
				break;
			default:
				break;
			}
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Unsupported locator in ui-map.properties: " + locator);
		}

		return by;
	}

}
