package starter.wikipedia;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.junit5.counter.SerenityTest;
import net.serenitybdd.junit5.counter.extension.CustomMethodNameTest;
import net.serenitybdd.junit5.counter.extension.DisplayNameTest;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
@DisplayNameGeneration(DisplayNameTest.class)
@SerenityTest
public class WhenSearchingForTerms {

    @Managed(driver = "chrome")
    WebDriver driver;

    NavigateActions navigate;

    SearchActions search;

    DisplayedArticle displayedArticle;

    @CustomMethodNameTest()
    void searchBySingleKeyword() {
        navigate.toTheHomePage();
        search.searchBy("Everest");
        Serenity.reportThat("The first heading should be 'Mount Everest'",
                () -> assertThat(displayedArticle.getFirstHeading()).isEqualTo("Mount Everest")
        );
    }
}
