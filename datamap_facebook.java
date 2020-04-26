package resources;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class datamap_facebook {
    WebDriver wd;
    @Given("^facebook login page appears$")
    public void facebookLoginPageAppears() {
        System.setProperty("WebDriver.Chrome.Driver", "ChromeDriver");
        wd = new ChromeDriver();
        wd.get("https://www.facebook.com");
    }

    @When("^entering the username and  password$")
    public void enteringTheUsernameAndPassword(DataTable credentials) throws InterruptedException {
        for(Map<String, String> data : credentials.asMaps(String.class, String.class)){

        wd.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(data.get("username"));
        wd.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(data.get("password"));
        Thread.sleep(4000);
    }
    }
    @And("^clicking the login button$")
    public void clickingTheLoginButton() {
        wd.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
    }

    @Then("^facebook home page comes$")
    public void facebookHomePageComes() {
        String exp = "Facebook - Log In or Sign Up";
        String act = wd.getTitle();
        Assert.assertEquals(exp, act);
    }
}
