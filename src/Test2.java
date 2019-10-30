import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.lang.Object;
import java.lang.String;

public class Test2 {
    private WebDriver driver;

    @Before

    public void before() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://testingcup.pgs-soft.com/task_1");

    }


    @Test
    public void add_basket()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> inputs = driver.findElements(By.xpath("//input"));

        List <WebElement> buttons = driver.findElements(By.xpath("//button"));

        int inputs_size;
        int buttons_size;
        int buttons_delete_size;

        inputs_size = inputs.size();
        buttons_size = buttons.size();

        WebElement element;

        for(int i=0;i<inputs_size;i++)
        {
            element = inputs.get(i);

            element.clear();
            element.sendKeys("2");

            element = buttons.get(i);

            element.click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        }

        List<WebElement>  buttons_delete = driver.findElements(By.xpath("//div[@class='col-md-12 basket-list']//button"));

        buttons_delete_size = buttons_delete.size();


        if(buttons_delete_size == 12){System.out.println("dodano każdą rzecz do koszyka w dwóch sztukach, test OK");}
            else System.out.println("nie dodano wszystkich itemów do koszyka");

    }
}
