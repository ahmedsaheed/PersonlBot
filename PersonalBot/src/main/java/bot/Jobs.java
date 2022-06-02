package bot;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Jobs {
    //initialising the web driver
    static WebDriver drive = null;

public void applyForJob() throws InterruptedException {
    //
    try{
        System.setProperty("webdriver.chrome.driver","/Users/ahmedsaheed/Desktop/Desktop/chromedriver");
        WebDriver driver  = new ChromeDriver();

        //navigating to the website
        driver.get("https://www.linkedin.com/login/");
        //wait for 5seconds
        TimeUnit.SECONDS.sleep(5);

        //login details
        String email = "ahmedsaheed2@outlook.com";
        String password = "Abdulrazaq1";

        //finding login element using the id

        WebElement usernames = driver.findElement(By.id("username"));
        WebElement passwords = driver.findElement(By.id("password"));
        usernames.sendKeys(email);
        passwords.sendKeys(password);
        passwords.sendKeys(Keys.RETURN);
        TimeUnit.SECONDS.sleep(5);

        //----------------------------------------------------------------------------------//
        //navigate to the job section & sleep for 5secs before proceeding
        String keyword = "Junior Software Developer";
        String locations = "Ireland";
        driver.get("https://www.linkedin.com/jobs/");
        TimeUnit.SECONDS.sleep(5);
        //locate the necessary search bars using the HTML id.
        WebElement searchKeyWord = driver.findElement(By.id("jobs-search-box-keyword-id-ember31"));
        WebElement searchLocation = driver.findElement(By.id("jobs-search-box-location-id-ember31"));
        searchKeyWord.sendKeys(keyword);
        searchLocation.sendKeys(locations);
        TimeUnit.SECONDS.sleep(1);
        searchLocation.sendKeys(Keys.RETURN);
        TimeUnit.SECONDS.sleep(5);

        //All jobs found are passed into a list and return individually.
        List<WebElement> listOfJobs = driver.findElements(By.className("occludable-update"));
        WebElement jobs= null;
        for(int i=0; i<listOfJobs.size(); i++){
            jobs = listOfJobs.get(i);
            //javascript execution to scroll the div into view
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", jobs);
            jobs.click();
            TimeUnit.SECONDS.sleep(5);
            WebElement details = driver.findElement(By.id("job-details"));
            String detail = details.getText();
            System.out.println("Job Description & Details:"+ "\n" +detail);
            System.out.println("\n");
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("Would you like to apply or not??");


            Scanner app = new Scanner(System.in);
            String choice = app.nextLine();
            if(choice.equals("apply")){
                System.out.println("You are currently applying for this job.");
                String phoneNumber = "0874197677";
                WebElement apply = driver.findElement(By.cssSelector(".jobs-s-apply button"));
                apply.click();
                System.out.println("Please provide your CV from the pop up");
                TimeUnit.SECONDS.sleep(2);
                WebElement fill = driver.findElement(By.cssSelector(".fb-single-line-text__input"));
                fill.sendKeys(phoneNumber);
                WebElement nextButton = driver.findElement(By.cssSelector("footer button"));
                nextButton.click();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Your CV has now been added");
                nextButton.click();


            }else{
                continue;
            }

        }
    }catch (Exception e){
        System.out.println("Error " + e );
    }


}






}

