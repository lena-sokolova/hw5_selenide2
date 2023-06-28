package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSolutionsHover {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void CheckUploadPageTest (){
    // открыть главную страницу
        open("https://github.com/");
    // выбрать меню Solutions -> Enterprize
        $("[aria-label='Global']").$(byText("Solutions")).hover();
        $("a[href='/enterprise']").click();
    // убедиться, что есть заголовок "Build like the best"
        $("h1").shouldHave(text("Build like the best"));
    }
}
