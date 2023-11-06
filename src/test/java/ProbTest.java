import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.internal.TestListenerHelper;

import java.util.List;

public class ProbTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://quickdraw.withgoogle.com/");
        driver.get("D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html");
        //WebElement element = driver.findElement(By.id("popup-quit"));
        //System.out.println(element);
//-----------------------------------------------------------
       // driver.findElement(By.id("div3")).findElement(By.name("same")).click();
        // Thread.sleep(500);
        // driver.close();
//-----------------------------------------------------------
        Thread.sleep(1500);
        //driver.findElement(By.className("btn-primary")).click();
        //driver.findElement(By.className("btn")).click();
    }

    @Test
   public void testInChrome(){
       System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("https://quickdraw.withgoogle.com/");
       WebElement element = driver.findElement(By.id("popup-quit"));
   }
   @Test
   public void testInEdge() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://novosti-n.org");
        Thread.sleep(3000);
        driver.quit();
   }

   @Test
    public void testButton() throws InterruptedException {
       System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html");
       Thread.sleep(3000);
       driver.findElement(By.className("btn-primary")).click();
       Thread.sleep(3000);
       driver.close();
   }

   @Test
    public void testMulti(){
       System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html");
       List<WebElement> checkBoxElements =
               driver.findElements(
                       By.xpath("//div[@id='container']//input[@type='checkbox']"));
       checkBoxElements.get(2).click();
       System.out.println(checkBoxElements.size());
   }

   @Test
    public void testHyperlink(){
       System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html");
       driver.findElement(By.linkText("About")).click();

       if(is_italian()){
           driver. findElement(By.linkText("Accedi")).click();
       }else {
           driver.findElement(By.linkText("Sigh in")).click();
       }

//       driver.findElement(By.id("about_link")).click();
   }

   @Test
   public void testByXPath(){
       System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html");
       driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
       //*[@id="about_link"]
   }

    @Test
    public void testByXPath1(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html");
        driver.findElement(
                By.xpath("//div[contains(text(),\"Second\")]/a[contains(text(),\"Click here\")]"))
                .click();
        //*[@id="about_link"]
    }
//  By.xpath("//*[contains(text(), \"Click here\")]"))
    private boolean is_italian() {
        return false;
    }

    @Test
    public void testNLink(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html");
        List<WebElement> elements = driver.findElements(By.linkText("Show Answer"));
        assert elements.size() == 3;
        elements.get(1).click();
    }

    @Test
    public void testCSSSelector(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html");
        driver.findElement(By.cssSelector("p > a:nth-child(0)")).click();
    }

    @Test
    public void testExistingLink(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html");
        assert driver.findElement(By.linkText("About")).isDisplayed();
        assert driver.findElement(By.id("about_link")).isDisplayed();
    }

    @Test
    public void testGetDataLink(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html");
        WebElement about = driver.findElement(By.linkText("About"));
        //assert about.getAttribute("href").equals(TestHelper.siteUrl()+"about.html");
        assert "about_link".equals(about.getAttribute("id"));
        assert "About".equals(about.getText());
        assert "a".equals(about.getTagName());
// !!!!       assert "font-size:24px;".equals(about.getAttribute("style"));
        assert "123".equals(about.getAttribute("data-id"));
    }

    @Test
    public void testButtonByLabel(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(TestHelper.siteUrl()+"index.html");
        driver.findElement(By.xpath("//button[contains(text(), 'Choose language')]")).click();
    }
    @Test
    public void testFormByLabel(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(TestHelper.siteUrl()+"index.html");
        driver.findElement(By.xpath("//input[@value='Send']")).click();
    }
    @Test
    public void testSubmitForm(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(TestHelper.siteUrl()+"index.html");
      //  WebElement user_element = driver.findElement(By.name("user"));
      //  user_element.sendKeys("Leo");
      //  WebElement password_element = driver.findElement(By.name("password"));
      //  user_element.sendKeys("1234");
      //  user_element.submit();
        driver.findElement(By.name("user")).sendKeys("Dina");
        driver.findElement(By.name("password")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value='Send']"));
    }
    @Test
    public void testButtonById(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(TestHelper.siteUrl()+"index.html");
        driver.findElement(By.id("choose_language_btn"));
    }

    @Test
    public void testButtonByName(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(TestHelper.siteUrl()+"index.html");
        driver.findElement(By.name("submit_action")).click();
}


    @Test
    public void testImageButton(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(TestHelper.siteUrl()+"index.html");
        driver.findElement(By.xpath("//input[contains(@src,'_now.png')]")).click();
}
    @Test
    public void testEnterTextToField(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(TestHelper.siteUrl()+"web/text_area_field.html");
        driver.findElement(By.name("username")).sendKeys("traktorbek");
        driver.findElement(By.id("pass")).sendKeys("X3");
    }
}
