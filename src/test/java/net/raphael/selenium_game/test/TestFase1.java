package net.raphael.selenium_game.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

public class TestFase1 {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://vanilton.net/selenium/game/");
        WebElement botaoX = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='modalInitial']//button[@class='close']")));
        botaoX.click();
    }

    @Test
    public void loginValido(){
        driver.findElement(By.id("nome")).sendKeys("caboquinho");
        driver.findElement(By.xpath("//input[@id='senha']")).sendKeys("0123456789");
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[name=entrar]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login efetuado com sucesso!", msgRetorno);
    }

    @Test
    public void loginInvalido(){
        driver.findElement(By.id("nome")).sendKeys("julieta");
        driver.findElement(By.xpath("//input[@id='senha']")).sendKeys("0123456789");
        driver.findElement(By.name("entrar")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login incorreto!", msgRetorno);
    }

    @Test
    public void fase1Quest1(){
        driver.findElement(By.id("nome")).sendKeys("caboquinho");
        driver.findElement(By.xpath("//input[@id='senha']")).sendKeys("0123456789");
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[name=entrar]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login efetuado com sucesso!", msgRetorno);

        driver.findElement(By.cssSelector("label[for*=radio5]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#quiz1 > button.mdl-button.mdl-js-button")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String quiz1Status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quiz1_status"))).getText();
        Assert.assertEquals("Questão 2 de 4", quiz1Status);
    }

    @Test
    public void fase1Quest2(){
        driver.findElement(By.id("nome")).sendKeys("caboquinho");
        driver.findElement(By.xpath("//input[@id='senha']")).sendKeys("0123456789");
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[name=entrar]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login efetuado com sucesso!", msgRetorno);

        driver.findElement(By.cssSelector("label[for*=radio5]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#quiz1 > button.mdl-button.mdl-js-button")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String quiz1Status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quiz1_status"))).getText();
        Assert.assertEquals("Questão 2 de 4", quiz1Status);

        driver.findElement(By.cssSelector("label[for*=radio4]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#quiz1 > button.mdl-button.mdl-js-button")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String quiz1Status1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quiz1_status"))).getText();
        Assert.assertEquals("Questão 3 de 4", quiz1Status1);

    }


    @Test
    public void fase1Quest3(){
        driver.findElement(By.id("nome")).sendKeys("caboquinho");
        driver.findElement(By.xpath("//input[@id='senha']")).sendKeys("0123456789");
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[name=entrar]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login efetuado com sucesso!", msgRetorno);

        driver.findElement(By.cssSelector("label[for*=radio5]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#quiz1 > button.mdl-button.mdl-js-button")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String quiz1Status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quiz1_status"))).getText();
        Assert.assertEquals("Questão 2 de 4", quiz1Status);

        driver.findElement(By.cssSelector("label[for*=radio4]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#quiz1 > button.mdl-button.mdl-js-button")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String quiz1Status1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quiz1_status"))).getText();
        Assert.assertEquals("Questão 3 de 4", quiz1Status1);

        driver.findElement(By.cssSelector("label[for*=radio2]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#quiz1 > button.mdl-button.mdl-js-button")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String quiz1Status2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quiz1_status"))).getText();
        Assert.assertEquals("Questão 4 de 4", quiz1Status2);

    }


    public void fase1Quest4(){
        driver.findElement(By.id("nome")).sendKeys("caboquinho");
        driver.findElement(By.xpath("//input[@id='senha']")).sendKeys("0123456789");
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[name=entrar]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login efetuado com sucesso!", msgRetorno);

        driver.findElement(By.cssSelector("label[for*=radio5]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#quiz1 > button.mdl-button.mdl-js-button")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String quiz1Status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quiz1_status"))).getText();
        Assert.assertEquals("Questão 2 de 4", quiz1Status);

        driver.findElement(By.cssSelector("label[for*=radio4]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#quiz1 > button.mdl-button.mdl-js-button")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String quiz1Status1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quiz1_status"))).getText();
        Assert.assertEquals("Questão 3 de 4", quiz1Status1);

        driver.findElement(By.cssSelector("label[for*=radio2]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#quiz1 > button.mdl-button.mdl-js-button")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String quiz1Status2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quiz1_status"))).getText();
        Assert.assertEquals("Questão 4 de 4", quiz1Status2);

        driver.findElement(By.cssSelector("label[for*=radio2]")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#quiz1 > button.mdl-button.mdl-js-button")).click();
        wait.withTimeout(50, TimeUnit.SECONDS);
        String quiz1Status3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quiz2_status"))).getText();
        Assert.assertEquals("Questão 1 de 2", quiz1Status3);

    }



    @After
    public void tearDown(){
        driver.quit();
    }

}