package com.sahitest.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://sahitest.com/demo/linkTest.htm")
public class LinkTestPage extends PageObject{
	public static final Target LINK_BY_CONTENT = Target.the("linkByContent").located(By.linkText("linkByContent"));
	public static final Target LINK_BY_HTML = Target.the("linkByHtml").located(By.linkText("linkByHtml"));
	public static final Target BACK = Target.the("back").locatedBy("//*[@href='linkTest.htm']");
}
