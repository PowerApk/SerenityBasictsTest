package com.sahitest.stepdefinitions;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.sahitest.userinterfaces.AlertsTestPage;
import com.sahitest.userinterfaces.ClicksTestPage;
import com.sahitest.userinterfaces.IframeTestPage;
import com.sahitest.userinterfaces.LinkTestPage;
import com.sahitest.userinterfaces.NewTabTestPage;
import com.sahitest.userinterfaces.PopUpTestPage;
import com.sahitest.userinterfaces.ScrollTestPage;
import com.sahitest.userinterfaces.SelectTestPage;
import com.sahitest.userinterfaces.TextAlertsTestPage;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Managed;

public class PragmaTestStepDef {

	private LinkTestPage linkTestPage;
	private SelectTestPage selectTePage;
	private IframeTestPage iFramePage;
	private ClicksTestPage clicksPage;
	private AlertsTestPage alertsPage;
	private TextAlertsTestPage textAlertPage;
	private NewTabTestPage newTabPage;
	private PopUpTestPage popUpPage;
	private ScrollTestPage scrollPage;

	// Ejecutar prueba en firefox
//	 @Managed(driver = "firefox")
	// Ejecutar prueba en chrome
	@Managed(driver = "chrome")
	private WebDriver hisBrowser;
	private Actor testerUser = Actor.named("Alejo");

	@Before
	public void setUp() {
		testerUser.can(BrowseTheWeb.with(hisBrowser));
		hisBrowser.manage().window().maximize();
	}

	@Given("^that test start$")
	public void thatTestStart() {
		testerUser.attemptsTo(Open.browserOn(linkTestPage));
	}

	@When("^LinksTest$")
	public void linkstest() {
		System.out.println("LinksTest");
		testerUser.attemptsTo(Click.on(LinkTestPage.LINK_BY_CONTENT), Click.on(LinkTestPage.BACK),
				Click.on(LinkTestPage.LINK_BY_HTML));
	}

	@When("^SelectsTest$")
	public void selectstest() {
		System.out.println("SelectsTest");
		testerUser.attemptsTo(Open.browserOn(selectTePage), Click.on(SelectTestPage.FILTER_1),
				Click.on(SelectTestPage.FILTER_1_OPTION_2),
				SelectFromOptions.byVisibleText("o2").from(SelectTestPage.FILTER_2),
				SelectFromOptions.byIndex(5).from(SelectTestPage.FILTER_3),
				SelectFromOptions.byValue("o3val").from(SelectTestPage.FILTER_4),
				Enter.keyValues("Home").into(SelectTestPage.FILTER_5));
	}

	@When("^IframesTest$")
	public void iframestest() {
		System.out.println("IframesTest");
		testerUser.attemptsTo(Open.browserOn(iFramePage));
		hisBrowser.switchTo().frame(hisBrowser.findElement(By.xpath(IframeTestPage.IFRAME_1)));
		testerUser.attemptsTo(Click.on(IframeTestPage.SOME_LINK));
		hisBrowser.switchTo().defaultContent();
		hisBrowser.switchTo().defaultContent();
		hisBrowser.switchTo().frame(hisBrowser.findElement(By.xpath(IframeTestPage.IFRAME_2)));
		testerUser.attemptsTo(Click.on(IframeTestPage.SOME_LINK));
		hisBrowser.switchTo().defaultContent();
		testerUser.attemptsTo(Click.on(IframeTestPage.BUTTON));
	}

	@When("^ClicksTest$")
	public void clickstest() throws InterruptedException {
		System.out.println("ClicksTest");
		Actions actions = new Actions(hisBrowser);
		testerUser.attemptsTo(Open.browserOn(clicksPage));
		ClicksTestPage.BUTTON_CLICK.resolveFor(testerUser).click();
		actions.doubleClick(hisBrowser.findElement(By.xpath(ClicksTestPage.BUTTON_DOUBLE_CLICK))).build().perform();
		actions.contextClick(hisBrowser.findElement(By.xpath(ClicksTestPage.BUTTON_RIGTH_CLICK))).build().perform();
	}

	@When("^AlertsTest$")
	public void alertstest() {
		System.out.println("AlertsTest");
		testerUser.attemptsTo(Open.browserOn(alertsPage));
		AlertsTestPage.ALERT_BUTTON.resolveFor(testerUser).click();
		hisBrowser.switchTo().alert().accept();
		AlertsTestPage.ALERT_BUTTON.resolveFor(testerUser).click();
		hisBrowser.switchTo().alert().dismiss();
	}

	@When("^TextAlertsTest$") 
	public void textalertstest() throws InterruptedException {
		System.out.println("TextAlertsTest");
		testerUser.attemptsTo(Open.browserOn(textAlertPage), Click.on(TextAlertsTestPage.ALERT_BUTTON));
		Alert alert = hisBrowser.switchTo().alert();
		alert.sendKeys("Hola Mundo¡");
		alert.accept();
		System.out.println("Mensaje: " + TextAlertsTestPage.TXT_MESSAGE.resolveFor(testerUser).getTextValue());
	}

	@When("^NewWindowTest$")
	public void newwindowtest() {
		System.out.println("NewWindowTest");
		testerUser.attemptsTo(Open.browserOn(newTabPage), Click.on(NewTabTestPage.LINK_NEW_TAB));
		ArrayList tabs = new ArrayList(hisBrowser.getWindowHandles());
		hisBrowser.switchTo().window("" + tabs.get(1));
		hisBrowser.switchTo().frame(hisBrowser.findElement(By.name("top")));
		testerUser.attemptsTo(Click.on(NewTabTestPage.LINK_TEST));
	}

	@When("^PopUpTest$")
	public void popuptest() {
		System.out.println("PopUpTest");
		testerUser.attemptsTo(Open.browserOn(popUpPage), Click.on(PopUpTestPage.BUTTON_CALCULATOR_INITIAL));
		ArrayList tabs = new ArrayList(hisBrowser.getWindowHandles());
		hisBrowser.switchTo().window("" + tabs.get(2));
		testerUser.attemptsTo(Click.on(PopUpTestPage.BUTTON_1), Click.on(PopUpTestPage.BUTTON_SUM),
				Click.on(PopUpTestPage.BUTTON_3), Click.on(PopUpTestPage.BUTTON_RESULT));
		hisBrowser.close();
		tabs = new ArrayList(hisBrowser.getWindowHandles());
		hisBrowser.switchTo().window("" + tabs.get(1));
		testerUser.attemptsTo(Open.browserOn(popUpPage), Click.on(PopUpTestPage.BUTTON_CALCULATOR_LAST));
		hisBrowser.switchTo().window("" + tabs.get(0));
		hisBrowser.switchTo().defaultContent();
	}

	@When("^ScrollTest$")
	public void scrolltest() {
		System.out.println("ScrollTest");
		testerUser.attemptsTo(Open.browserOn(scrollPage));
		hisBrowser.switchTo().alert().dismiss();
		Actions actions = new Actions(hisBrowser);
		JavascriptExecutor js = (JavascriptExecutor) hisBrowser;
		js.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));");
		
	}

	@Then("^test ends$")
	public void testEnds() throws InterruptedException {
		System.out.println("Fin");
		Thread.sleep(1000);
	}

}