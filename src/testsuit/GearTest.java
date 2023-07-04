package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl="https://magento.softwaretestingboard.com/";
    @Before
    public void setUrl()
    {
        openBrowser(baseUrl);
    }
    //5.Write down the following test into ‘GearTest’ class
    //1
    @Test
    public  void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
//Mouse Hover on Gear Menu
        WebElement geraMenu = driver.findElement(By.xpath("//a[@id='ui-id-6']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(geraMenu).build().perform();

        //Click on Bags
        driver.findElement(By.xpath("//span[contains(text(),'Bags')]")).click();

        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
      //  driver.findElement(By.xpath("//a[contains(text(),'Overnight Duffle')]")).click();

        //Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");
       // driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("3");
//Click on ‘Add to Cart’ Button.
        driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String actualText=driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        String expectedText="You added Overnight Duffle to your shopping cart.";
        Assert.assertEquals("Not Matched Any Text",expectedText,actualText);

        //Click on ‘shopping cart’ Link into message
        driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]")).click();

        //Verify the product name ‘Overnight Duffle’
        actualText=driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']")).getText();
        expectedText="Overnight Duffle";
        Assert.assertEquals("Not Matched Any Text",expectedText,actualText);
    }

    @After
    public void terdown(){
        closeBrowser();
    }
}



