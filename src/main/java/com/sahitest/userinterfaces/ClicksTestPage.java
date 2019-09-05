package com.sahitest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://sahitest.com/demo/clicks.htm")
public class ClicksTestPage extends PageObject {

	public static final Target BUTTON_CLICK = Target.the("one click button").locatedBy("//input[@value='click me']");
	public static final String BUTTON_DOUBLE_CLICK = "//input[@value='dbl click me']";
	public static final String BUTTON_RIGTH_CLICK = "//input[@value='right click me']";
}
