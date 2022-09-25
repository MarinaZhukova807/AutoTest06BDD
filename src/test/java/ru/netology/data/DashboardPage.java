package ru.netology.data;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    // к сожалению, разработчики не дали нам удобного селектора, поэтому так
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private SelenideElement heading1 = $("[data-test-id='dashboard']");
    private SelenideElement heading2 = $(byText("Ваши карты"));
    private SelenideElement reloadButton = $("[data-test-id='action-reload']");

    public void DashboardPage() {
        heading1.shouldBe(Condition.visible);
        heading2.shouldBe(Condition.visible);
    }

    public int getCardBalance(int index) {
        val text = cards.get(index).text();
        return extractBalance(text);
    }

    public TopUpPage topUpBalance(int id) {
        cards.get(id).$(byText("Пополнить")).click();
        return new TopUpPage();
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

}