package com.sahitest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.wextensible.com/temas/xhtml-css/script.html#ejemplo-window")
public class PopUpTestPage extends PageObject{
	
	public static final Target BUTTON_CALCULATOR_LAST = Target.the("calculator button").locatedBy("//input[@onclick='abreCalculadora()']");
	public static final Target BUTTON_CALCULATOR_INITIAL = Target.the("calculator button").locatedBy("//input[@onclick='nuevaVentana()']");
	public static final Target BUTTON_1 = Target.the("calculator button 1").locatedBy("//input[@value='1']");
	public static final Target BUTTON_3 = Target.the("calculator button 3").locatedBy("//input[@value='3']");
	public static final Target BUTTON_SUM = Target.the("calculator button sum operator").locatedBy("//input[@value='+']");
	public static final Target BUTTON_RESULT = Target.the("calculator button result").locatedBy("//input[@value='=']");

}
