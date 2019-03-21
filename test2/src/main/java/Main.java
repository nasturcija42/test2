import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\test2\\drivers\\chromedriver.exe");

      WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Wait<WebDriver> wait = new WebDriverWait(chromeDriver, 20, 1000);

//        chromeDriver.manage().window().maximize();

        chromeDriver.get("http://xn--c1a1b.xn--p1ai/");
        WebElement chromeApp = chromeDriver.findElement(By.xpath("//div[@class=\"presentation__switchers\"]"));
        chromeDriver.findElement(By.xpath("//button//img[@src=\"assets/icons/food.png\"]")).click();
        chromeDriver.findElement(By.xpath("//a[@href=\"#food\"]")).click();
//        chromeDriver.findElement(By.xpath("//a[@href=\"https://dostavka.a42.ru/?utm_source=digitalcity\"]")).sendKeys(Keys.ENTER);
        chromeDriver.get("https://dostavka.a42.ru/?utm_source=digitalcity");
        chromeDriver.get("https://dostavka.a42.ru/catalog/2");
//        wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath("//button[@class=\"sendpulse-prompt-close\"]")))); // элемент не находится
//        chromeDriver.findElement(By.xpath("//button[@class=\"sendpulse-prompt-close\"]")).click();
//        chromeDriver.findElement(By.xpath("//a[@class=\"shop-card shop-27HFho\"][@href=\"/catalog/2\"]")).sendKeys(Keys.ENTER); // элемент не находится
        chromeDriver.findElement(By.xpath("//input[@class=\"search-bar__input\"]")).sendKeys("пицца пепперони");
        chromeDriver.findElement(By.xpath("//button[@class=\"search-bar__submit\"]")).sendKeys(Keys.ENTER);
        List<WebElement> itemList = chromeDriver.findElements(By.xpath("//div[@class=\"card-zg1J9N card-1JojJv product-36MfGJ\"]"));
        boolean itemCounterMoreThenOne = itemList.size() > 1 ? true : false;
        System.out.println(itemCounterMoreThenOne);
        Iterator<WebElement> iterator = itemList.iterator();
        boolean hasAddToCard = true;
        try {
            chromeDriver.findElement(By.xpath("//button[@class=\"button button_size_xs button_skin_primary button-4nZvAK\"]"));
        } catch (NoSuchElementException e) {
            hasAddToCard = false;
        }
        System.out.println(hasAddToCard);

    }
}