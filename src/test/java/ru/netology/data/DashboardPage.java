package ru.netology.data;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    // к сожалению, разработчики не дали нам удобного селектора, поэтому так
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private final SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement reloadButton = $("[data-test-id='action-reload']");

    public void Dashboard() {
        heading.shouldBe(Condition.visible);
    }

    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }

    public int getCardBalance(int index) {
        val text = cards.get(index).text();
        return extractBalance(text);
    }

    public TopUpPage topUpBalanceFirstCard() {
        cards.first().$("button").click();
        return new TopUpPage();

    }

    public TopUpPage topUpBalanceSecondCard() {
        cards.last().$("button").click();
        return new TopUpPage();
    }

    public TopUpPage upDate() {
        reloadButton.click();
        return new TopUpPage();
    }
    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }


}