package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

    public class Utility extends BaseTest {
        /**
         * This method will click on element
         */
        public void clickOnElement(By by){
     /*   //WebElement loginLink = driver.findElement(by);
        // loginLink.click();*/
            driver.findElement(by).click();
        }

        public String getTextFromElement(By by){

            return driver.findElement(by).getText();
        }
        /**
         * This method will send text to element
         */
        public void sendTextToElement(By by, String text){

            driver.findElement(by).sendKeys(text);
        }

        // -------------------------------Alert Methods----------------------------------

        /**
         * 5 Alerts (5 methods )
         * 5.1 Alerts method for switch to alert
         */
        public void switchTo(By by)
        {
            clickOnElement(by);
            driver.switchTo().alert();
        }


        /**
         * 5.2 Alerts method for accept popup
         */
        public void acceptAlert()
        {
            driver.switchTo().alert().accept();
        }


        /**
         * 5.3 Alerts method for dismiss popup
         */
        public void dismissAlert()
        {
            driver.switchTo().alert().dismiss();
        }


        /**
         * 5.4 Alerts method for sendkey
         */
        public void sendKeyAlert(String text)
        {
            driver.switchTo().alert().sendKeys(text);
        }


        /**
         * 5.5 Alerts method for gettext
         */
        public void getTextAlert()
        {
            driver.switchTo().alert().getText();
        }


        /**
         * 6. Action ---> mouse hover
         */
        public void mouseHover(By by, By by1)
        {
            WebElement text1 = driver.findElement(by);
            WebElement text2 = driver.findElement(by1);
            Actions actions= new Actions(driver);
            actions.moveToElement(text1).moveToElement(text2).click().build().perform();
        }
        public void mouseHoverOnElement(By by) throws InterruptedException {
            WebElement element = driver.findElement(by);
            Thread.sleep(1000);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
        }

        public void mouseHoverAndClickOnElement(By by) {
            Actions actions = new Actions(driver);
            WebElement text1 = driver.findElement(by);
            actions.moveToElement(text1).click().build().perform();
        }

        //---------------------------------------------Select Class method---------
        /**
         * This method will select the option by visible text
         */
        public void selectByVisibleTextFromDropDown(By by, String text){
            WebElement dropDown = driver.findElement(by);
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
        }
        /**This method will select the option by vslue*/
        public void selectByValueFromDropDown(By by,String value){

            //  new Select(driver.findElement(by""))
            WebElement dropDown = driver.findElement(by);
            Select select = new Select(dropDown);
            select.selectByVisibleText(value);
        }


        /**This method will select the option by index
         */

        public void selectByIndexFromDropDown(By by,int index){
            WebElement dropDown =driver.findElement(by);
            Select select= new Select(dropDown);
            select.selectByIndex(index);
        }
        /*
         * This method will element verify text
         */
        public void verifyText(By by, String expectedText) {
            String actualText = driver.findElement(by).getText();
            Assert.assertEquals("Not match text", expectedText, actualText);
        }
    }









