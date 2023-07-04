package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {
    String baseUrl="= https://magento.softwaretestingboard.com/";
    @Before
    public void setUrl(){
        openBrowser(baseUrl);
    }
    //Write down the following test into WomenTestclass
    //1. verifyTheSortByProductNameFilter
    @Test
    public void verifyTheSortByProductNameFilter() {

//* Mouse Hover on Women Menu
//* Mouse Hover on Tops
//* Click on Jackets
        mouseHover(By.xpath("//a[@id='ui-id-4']"),By.xpath("//strong[contains(text(),'Tops')]"));
        clickOnElement(By.xpath("//header/div[2]"));

//* Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='sorter']"),"Product Name");

//* Verify the products name display in alphabetical order
        List<WebElement> PRODUCTName = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement product :PRODUCTName){
            System.out.println(product.getText());
        }
    }
//2. verifyTheSortByPriceFilter
    public void verifyTheSortByPriceFilter() {
//* Mouse Hover on Women Menu Mouse Hover on Tops
        mouseHover(By.xpath("//a[@id='ui-id-4']"),By.xpath("//strong[contains(text(),'Tops')]"));


//* Click on Jackets
        clickOnElement(By.xpath("//header/div[2]"));
//* Select Sort By filter “Price”
        selectByValueFromDropDown(By.xpath("//div[@class='toolbar-sorter sorter']//select[@id='sorter']"),"price");
//* Verify the products price display in Low to High
        List<WebElement> List2 = driver.findElements(By.xpath("//div[@class = 'price-box price-final_price']"));
        for (int i = 0; i < List2.size(); i++) {
            System.out.println(List2.get(i).getText());
            String expected = List2.get(i).getText();
            String actual = List2.get(i).getText();
            Assert.assertEquals("Price not ordered : Low to High  ", expected, actual);
        }

    }



    @After
    public void terdown(){
        closeBrowser();
    }
}
