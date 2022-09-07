package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideTest {

    private static final String NAME = "KotlinUdemy";

    StepsForTest stepsForTest = new StepsForTest();

    @BeforeAll
    static void beforeAllTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void clearSelenideTest() {

        open("https://github.com/");

        $("[name=\"q\"]").setValue(NAME);
        $("[name=\"q\"]").submit();
        $(new ByText("KotlinUdemy")).click();
        $("#issues-tab").shouldHave(Condition.text("Issues"));
    }

    @Test
    void selenideWithLambdaTest() {
        step("Открыть главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ввести" + NAME, () -> {
            $("[name=\"q\"]").setValue(NAME);
        });

        step("Подтвердить выбор", () -> {
            $("[name=\"q\"]").submit();
            ;
        });

        step("Выбрать" + NAME, () -> {
            $(new ByText(NAME)).click();
        });

        step("Проверка наличия Issues", () -> {
            $("#issues-tab").shouldHave(Condition.text("Issues"));
        });
    }

    @Test
    void SelenideWithJStepsTest() {
        stepsForTest.openGitHubPage();
        stepsForTest.enterName();
        stepsForTest.findName();
        stepsForTest.findIssues();
    }
}