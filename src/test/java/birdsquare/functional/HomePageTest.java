package birdsquare.functional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertTrue;

public class HomePageTest {

    private WebDriver webDriver;
    private static String HOME_PAGE_URL = Environments.getHomePageUrl();

    @Before
    public void setUp() {
        webDriver = new HtmlUnitDriver();
        webDriver.get(HOME_PAGE_URL);
    }

    @Test
    public void shouldShowHomePage() {
        WebElement mainContentElement = webDriver.findElement(By.id("home-content"));
        assertTrue(mainContentElement.getText().contains("Welcome to BirdSquare"));
        assertTrue(webDriver.findElement(By.linkText("Check In")).isDisplayed());
    }

}
