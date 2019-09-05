package com.sahitest.utils;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.webdriver.WebDriverFacade;

public class Utilidades {
	
	public static void focusMainContainer(WebDriverFacade hisBrowser) {
		hisBrowser.switchTo().defaultContent();
	}
	
	public static void focusIframe(WebDriverFacade hisBrowser) {
		WebElement iFrameFinw= hisBrowser.findElement(By.name("FINW"));			
		hisBrowser.switchTo().frame(iFrameFinw);
		WebElement iFrameMenuTree= hisBrowser.findElement(By.id("menutree"));
		hisBrowser.switchTo().frame(iFrameMenuTree);
	}

}
