import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.GeckoDriverService;


@RunWith(SerenityRunner.class)
public class SimpleSerenityTest {
NEw line added
    seconf line added
    @Managed
        WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "D:\\AuotDriver\\geckodriver.exe");
    }

    @Test
    public void simpleSerenityTest() {
        driver.get("https://www.example.com");
        System.out.println("Title of the page: " + driver.getTitle());
    }
}
