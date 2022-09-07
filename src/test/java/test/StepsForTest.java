package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsForTest {

    private static final String NAME = "KotlinUdemy";

    @Step("Переход на главную страницу")
    public void openGitHubPage() {
        open("https://github.com/");
    }

    @Step("Ввод NAME")
    public void enterName() {
        $("[name=\"q\"]").setValue(NAME);
        $("[name=\"q\"]").submit();
    }

    @Step("Выбор NAME")
    public void findName() {
        $(new ByText("KotlinUdemy")).click();
    }

    @Step("Проверка наличие Issues")
    public void findIssues() {
        $("#issues-tab").shouldHave(Condition.text("Issues"));
    }
}
