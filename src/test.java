import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {

    private WebDriver driver;

    @Before

    public void before()
    {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("https://testingcup.pgs-soft.com/task_1");


    }


    @Test
    public void add_more_basket()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       List<WebElement> inputs = driver.findElements(By.xpath("//input"));

        List <WebElement> buttons = driver.findElements(By.xpath("//button"));

        int inputs_size;
        int buttons_size;
        int counter = 0;

        inputs_size = inputs.size();
        buttons_size = buttons.size();

        WebElement element;

        for(int i=0;i<inputs_size;i++)
        {
            element = inputs.get(i);

            element.sendKeys("102");

            element = buttons.get(i);

            element.click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Alert alert = driver.switchTo().alert();

            String alert_text = driver.switchTo().alert().getText();




                if (alert_text.equals("Łączna ilość produktów w koszyku nie może przekroczyć 100."))
                {



                    counter++;

                }
                else {System.out.println("nie mozna wypełnić inputa" + counter);}

                driver.switchTo().alert().accept();
        }

        if(counter==12){System.out.println("zbyt duza ilosc danych w koszyku, test OK");}

    }

    @After

    public void after()
    {

        driver.quit();

    }

}
