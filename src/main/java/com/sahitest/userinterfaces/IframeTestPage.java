package com.sahitest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://sahitest.com/demo/iframesTest.htm")
public class IframeTestPage extends PageObject{
	
	public static final String IFRAME_1 = "//body/iframe";
	public static final String IFRAME_2 = "//body/div/iframe";
	public static final Target SOME_LINK = Target.the("some link").locatedBy("//a[@href='blank.htm']");
	public static final Target BUTTON = Target.the("Click me button").locatedBy("//body/input[@type='button']");

}
