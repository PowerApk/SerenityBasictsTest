package com.sahitest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://sahitest.com/demo/index.htm")
public class NewTabTestPage extends PageObject{
	
	public static final Target LINK_NEW_TAB = Target.the("open new tab link").locatedBy("//a[text()='Window Open Test']");
	public static final Target LINK_TEST = Target.the("some link").locatedBy("//a[text()='Window Open Test']");
}
