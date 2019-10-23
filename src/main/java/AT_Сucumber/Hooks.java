package AT_Сucumber;

import Pages.OzonSearchPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;

public class Hooks {
   @Before
    public  void beforeHook(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        System.out.println("Тест начался");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 6000;
        open(OzonSearchPage.URL);

    }
    @After
    public void afterHook() throws InterruptedException {
        System.out.println("Тест Закончился");
        WebDriverRunner.closeWebDriver();
    }
}
