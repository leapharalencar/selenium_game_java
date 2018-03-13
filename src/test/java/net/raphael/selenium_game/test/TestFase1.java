package net.raphael.selenium_game.test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestFase1 {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver,5);
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
        driver.findElement(By.name("entrar")).click();
        wait.withTimeout(15, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login efetuado com sucesso!", msgRetorno);

    }

    @Test
    public void loginInvalido(){
        driver.findElement(By.id("nome")).sendKeys("Maria ");
        driver.findElement(By.xpath("//input[@id='senha']")).sendKeys("0123456789");
        driver.findElement(By.name("entrar")).click();
        wait.withTimeout(15, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login incorreto!", msgRetorno);

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
