package com.sahitest.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://sahitest.com/demo/selectTest.htm")
public class SelectTestPage extends PageObject{
	
	public static final Target FILTER_1 = Target.the("linkByContent").located(By.id("s1Id"));
	public static final Target FILTER_1_OPTION_2 = Target.the("linkByContent").located(By.id("id1"));
	public static final Target FILTER_2 = Target.the("linkByContent").located(By.id("s2Id"));
	public static final Target FILTER_3 = Target.the("linkByContent").located(By.id("s3Id"));
	public static final Target FILTER_4 = Target.the("linkByContent").located(By.id("s4Id"));
	public static final Target FILTER_5 = Target.the("linkByContent").located(By.id("s1"));
	
}
