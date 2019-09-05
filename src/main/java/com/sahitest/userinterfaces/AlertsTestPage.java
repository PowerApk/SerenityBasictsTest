package com.sahitest.userinterfaces;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://sahitest.com/demo/confirmTest.htm")
public class AlertsTestPage extends PageObject{

	public static final Target ALERT_BUTTON = Target.the("prompt alert button").locatedBy("//input[@name='b1']");
	
}
