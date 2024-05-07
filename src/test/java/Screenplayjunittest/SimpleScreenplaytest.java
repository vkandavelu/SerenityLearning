package Screenplayjunittest;


        import net.serenitybdd.annotations.Managed;
        import net.serenitybdd.annotations.Narrative;
        import net.serenitybdd.junit.runners.SerenityRunner;
        import net.serenitybdd.screenplay.Actor;
        import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
        import net.serenitybdd.screenplay.actions.Click;
        import net.serenitybdd.screenplay.actions.Enter;
        import net.serenitybdd.screenplay.actions.Open;
        import net.serenitybdd.screenplay.questions.Text;
        import net.serenitybdd.screenplay.ui.Button;
        import net.serenitybdd.screenplay.ui.PageElement;
        import net.serenitybdd.screenplay.ui.InputField;
        import org.junit.Before;
        import org.junit.BeforeClass;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.GeckoDriverService;

        import java.awt.*;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.Matchers.equalTo;


@Narrative(text={"In order to test complex interactions",
        "As a Serenity developer",
        "I want to interact with forms and validate responses"})
@RunWith(SerenityRunner.class)
public class SimpleScreenplaytest {

    @Managed
    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "D:\\AuotDriver\\geckodriver.exe");
    }

    @Test
    public void formInteractionTest() {
        Actor anna = Actor.named("Anna");
        anna.can(BrowseTheWeb.with(driver));
        anna.attemptsTo(
                Open.url("https://www.exampleform.com"),
                Enter.theValue("Hello World").into(InputField.withNameOrId("messageField")),
                Click.on(Button.withNameOrId("submitButton"))
        );

        // Assuming a response is displayed in a label with id "responseLabel"

        String response = Text.of(PageElement.withNameOrId("responseLabel")).answeredBy(anna).toString();
        assertThat(response, equalTo("Expected Response"));
        System.out.println("My branch 2");
    }
}