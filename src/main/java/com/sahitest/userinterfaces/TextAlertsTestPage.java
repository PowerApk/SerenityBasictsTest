package com.sahitest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://sahitest.com/demo/promptTest.htm")
public class TextAlertsTestPage extends PageObject {

	public static final Target ALERT_BUTTON = Target.the("prompt text alert button").locatedBy("//input[@name='b1']");
	public static final Target TXT_MESSAGE = Target.the("prompt text result").locatedBy("//input[@name='t1']");

}
